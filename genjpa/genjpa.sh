#!/bin/bash

Package=$1
Class=
Repository=
Domain=
IdType=


#----------------------
# 문자열을 소문자로 치환
#----------------------
Tolower()
{
    input=$*
	Result=`echo ${input,,}`
}

#----------------------
# 문자열을 대문자로 치환
#----------------------
Toupper()
{
    input=$*
    Result=`echo ${input^^}`
}

#----------------------
# 문자열의 첫글자만 대문자로 치환
#----------------------
ToupperFirst()
{
    input=$*
    Result=`echo ${input^}`
}

#----------------------
# 스네이크 케이스 문자열을 카멜케이스로 변경
#----------------------
SnakeCaseToCamelCase()
{
    Result=`echo $1 | sed -E 's/[ _-]([a-z])/\U\1/gi;s/^([A-Z])/\l\1/'`
}


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

generationDomain() 
{
   echo "package $Package.domain;" | tee $Domain

   cat $1 | tee -a $Domain
}

setIdType()
{
    id=($(grep "@Id //" $1))
	IdType=${id[2]}
}

generationRepository() 
{
   echo "package $Package.repository;" | tee $Repository
   echo "" | tee -a $Repository
   echo "import org.springframework.data.repository.PagingAndSortingRepository;" | tee -a $Repository
   echo "import org.springframework.data.rest.core.annotation.RepositoryRestResource;" | tee -a $Repository
   echo "import $Package.domain.$Class"';' | tee -a $Repository
   echo "" | tee -a $Repository
   
   Tolower $Class
   tmp="$Result"s
   
   echo "@RepositoryRestResource(collectionResourceRel=\"$tmp\", path=\"$tmp\")" | tee -a $Repository
   echo 'public interface '$Class'Repository extends PagingAndSortingRepository<'$Class", $IdType>{"  | tee -a $Repository
   echo  "}" | tee -a $Repository
}

main(){
   Initialize
   Package=$1
   cd tmp
   
   for file in `ls -1 *.java`
   do
       Class=`echo $file | sed 's/.java//g'`
	   setIdType $file
	   Repository="../repository/$Class"Repository.java
	   Domain="../domain/$file"
       
	   generationDomain $file
	   generationRepository
   done
}

if [ $# -ne 1 ]
then
    echo mssql jpa domain '&' repository generator
    echo usage : $0 package-path
else   
    main $1
fi