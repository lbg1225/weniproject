#!/bin/bash
#--------------------------------------------------------------
# mkmodel이 생성한 Entity Base Class 로
# JPA Domain & Repository Class를 생성하는 Script
#
# Created By SK Inc / Lee Byoung Gwan / lbg@sk.com / 2022-06-19
#--------------------------------------------------------------
Package=$1
Class=
Repository=
Domain=
IdType=
findfunc=

#----------------------
# 문자열을 소문자로 치환
#----------------------
Tolower()
{
    input=$*
	Result=`echo ${input,,}`
}

#--------------------------------------------------------------
# 문자열을 대문자로 치환
#--------------------------------------------------------------
Toupper()
{
    input=$*
    Result=`echo ${input^^}`
}

#--------------------------------------------------------------
# 문자열의 첫글자만 대문자로 치환
#--------------------------------------------------------------
ToupperFirst()
{
    input=$*
    Result=`echo ${input^}`
}

#--------------------------------------------------------------
# 스네이크 케이스 문자열을 카멜케이스로 변경
#--------------------------------------------------------------
SnakeCaseToCamelCase()
{
    Result=`echo $1 | sed -E 's/[ _-]([a-z])/\U\1/gi;s/^([A-Z])/\l\1/'`
}


#--------------------------------------------------------------
# Initialize 
#--------------------------------------------------------------
Initialize()
{
    for dir in `echo domain repository`
    do
	    if [ -d $dir ]
	    then
		    rm -rf $dir
	    fi
        mkdir $dir
	done
}

#--------------------------------------------------------------
# generationJavaDoc : Java Doc 생성
#--------------------------------------------------------------
generationJavaDoc()
{
    OutFile=$1
	
    echo '/** ' | tee $OutFile

	case $2 in
	    P)   echo '* '"$Class Entity Id 클래스 " | tee -a $OutFile ;;
	    E)   echo '* '"$Class Entity 클래스 " | tee -a $OutFile ;;
	    R)   echo '* '"$Class Entity 접근을 위한 Repository 클래스 " | tee -a $OutFile ;;
	esac

    echo "" | tee -a $OutFile
    echo '* @author  Lee Byoung Gwan' | tee -a $OutFile
    echo '* @version 1.0 ' | tee -a $OutFile

	case $2 in
	    R)   echo '* @see     org.springframework.data.repository.PagingAndSortingRepository'  | tee -a $OutFile ;;
    esac

    echo '*/' | tee -a $OutFile
}

#--------------------------------------------------------------
# generationDomain : Domain(Entity) Java 생성
#--------------------------------------------------------------
generationDomain() 
{
   generationJavaDoc $Domain $2
   
   echo "package $Package.domain;" | tee -a $Domain

   cat $1 | tee -a $Domain
}

#--------------------------------------------------------------
# setIdType : Domain(Entity) Java 생성
#--------------------------------------------------------------
setIdType()
{
    if [ "$findfunc" !=  "" ]
	then
	    IdType=$Class'PK'
	else
        id=($(grep "@Id //" $1))
	    IdType=${id[2]}
	fi
}

#--------------------------------------------------------------
# generationRepository : Domain(Entity) Repository Java 생성
#--------------------------------------------------------------
generationRepository() 
{
    generationJavaDoc $Repository R
    
    echo "package $Package.repository;" | tee -a $Repository
    echo "" | tee -a $Repository
    echo "import org.springframework.data.repository.PagingAndSortingRepository;" | tee -a $Repository
    echo "import org.springframework.data.rest.core.annotation.RepositoryRestResource;" | tee -a $Repository
    
    if [ "$findfunc" != "" ]
    then 
        echo "import org.springframework.data.rest.core.annotation.RestResource;" | tee -a $Repository;
        echo "import org.springframework.data.domain.Page;" | tee -a $Repository ; 
        echo "import org.springframework.data.domain.Pageable;" | tee -a $Repository ; 
    fi

    if [ `echo $findfunc | grep "BigDecimal " | wc -l` -gt 0 ]; then echo "import java.math.BigDecimal;" | tee -a $Repository; fi 
    if [ `echo $findfunc | grep "Date " | wc -l` -gt 0 ]; then echo "import java.sql.Date;" | tee -a $Repository; fi
    if [ `echo $findfunc | grep "Time " | wc -l` -gt 0 ]; then echo "import java.sql.Time;" | tee -a $Repository; fi 
    if [ `echo $findfunc | grep "Timestamp " | wc -l` -gt 0 ]; then echo "import java.sql.Timestamp;" | tee -a $Repository; fi 
    if [ `echo $findfunc | grep "Clob " | wc -l` -gt 0 ]; then echo "import java.sql.Clob;" | tee -a $Repository; fi 
    if [ `echo $findfunc | grep "Blob " | wc -l` -gt 0 ]; then echo "import java.sql.Blob;" | tee -a $Repository; fi 

    echo "import $Package.domain.$Class"';' | tee -a $Repository
    if [ "$findfunc" != "" ]; then echo "import $Package.domain.$IdType"';' | tee -a $Repository ; fi
    echo "" | tee -a $Repository
    
    Tolower $Class
    tmp="$Result"s
    
    echo "@RepositoryRestResource(collectionResourceRel=\"$tmp\", path=\"$tmp\")" | tee -a $Repository
    echo 'public interface '$Class'Repository extends PagingAndSortingRepository<'$Class", $IdType>{"  | tee -a $Repository
    
    if [ "$findfunc" != "" ]
    then  
        echo "    @RestResource" | tee -a $Repository
	    echo "    $findfunc" | tee -a $Repository
    fi
    
    echo  "}" | tee -a $Repository
}

#--------------------------------------------------------------
# Domain(Entity) & Repository Java 생성
#--------------------------------------------------------------
Generator()
{
    file=$1
	
	Domain="../domain/$file"
	case $file in
	   *PK.java)
	       generationDomain $file P 
		   ;;
	   *)
	       Class=`echo $file | sed 's/.java//g'`
	       Repository="../repository/$Class"Repository.java
		   setIdType $file
	       generationDomain $file E
	       generationRepository
		   ;;
	esac
}

#--------------------------------------------------------------
# Domain(Entity) & Repository Java 생성
#--------------------------------------------------------------
main(){
   Initialize
   Package=$1
   cd tmp
   
   for file in `ls -1 *.java`
   do  
       findfunc=`grep '// FindPK' $file`
	   Generator $file
   done
}

if [ $# -ne 1 ]
then
    echo mssql jpa domain '&' repository generator
    echo usage : $0 package-path
else   
    main $1
fi