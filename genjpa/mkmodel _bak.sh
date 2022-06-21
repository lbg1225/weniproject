#!/bin/bash

BaseDir=tmp
ClassName=
FileName=
Result=
Orgtable=
Table=
TableComment=
FileTmp=file.tmp
BuilderTmp=builder.tmp
Builder=
FirstCol=
BigDecimal="F"
Date="F"
Time="F"
Timestamp="F"

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

#----------------------
# Comment을 추출
#----------------------
GetComment()
{
    flag=false;
    for arg in "$@"
    do 
	    case $arg in
		     comment|COMMENT) flag=true ;;
 		     *) if [ $flag ] ;	then  Result=`echo // $arg | sed "s/'//g" | sed "s/,//"`; flag=false; fi		;;
	    esac	
    done	
}

ClassAddLine()
{
    echo $@ | tee -a $FileName
}

InitParam()
{
    cat /dev/null > $FileTmp
   
    BigDecimal="F"
    Date="F"
    Time="F"
    Timestamp="F"

	Builder=""
	FirstCol=""
	TableComment=""
}
   
#-------------------------------------
# CREATE TABLE [dbo].[TABLE]( 문자열 처리
# Class명 및 파일명 생성
#-------------------------------------
TableProc()
{
    input=$*
	
	InitParam
	Orgtable=`echo $3 | sed 's/\[dbo\]\.\[//' | sed 's/\](//g' | sed 's/\`//g'`
	Tolower $Orgtable
	SnakeCaseToCamelCase $Result
	ToupperFirst $Result
	
	Table=$Result
	ClassName=$Table
	FileName=$BaseDir/$ClassName.java
	
	cat /dev/null > $FileName
	cat /dev/null > $BuilderTmp
	
          
	# echo $ClassName
	# echo $FileName
}

BaseClass()
{	
    # ClassAddLine 'package com.weni.tmes.example.model;'
	if [ $BigDecimal == "T" ] ; then ClassAddLine 'import java.math.BigDecimal;'; fi
    if [ $Date == "T" ]       ; then ClassAddLine 'import java.sql.Date;'       ; fi
    if [ $Time == "T" ]       ; then ClassAddLine 'import java.sql.Time;'       ; fi
    if [ $Timestamp == "T" ]  ; then ClassAddLine 'import java.sql.Timestamp;'  ; fi
	ClassAddLine 'import java.io.Serializable;'
	ClassAddLine 'import javax.persistence.*;'
    ClassAddLine '// import org.springframework.beans.BeanUtils;'
    # ClassAddLine 'import lombok.Data;'
    ClassAddLine 'import lombok.AccessLevel;'
    ClassAddLine 'import lombok.Getter;'
    ClassAddLine 'import lombok.NoArgsConstructor;'
    ClassAddLine 'import lombok.EqualsAndHashCode;'
    ClassAddLine 'import lombok.ToString;'
    ClassAddLine 'import lombok.Builder;'
    ClassAddLine ''
    ClassAddLine '@Entity'
    ClassAddLine "@Table(name=\"$Orgtable\")"
    ClassAddLine '@Getter'
    ClassAddLine '@NoArgsConstructor(access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC'
    ClassAddLine '@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))'  
	ClassAddLine '@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외'
	ClassAddLine "public class $ClassName implements Serializable { $TableComment"
}

PrePostFunc()
{
	for func in `echo Load Persist Update Remove`
	do
	    for gubun in `echo Pre Post`
		do   
            if [ $func == "Load" ] && [ $gubun == "Pre" ] ; then  continue ;	fi
	        echo "" >> $FileTmp
	        echo "    @$gubun$func" >> $FileTmp
            echo "    public void on$gubun$func() {" >> $FileTmp
	        echo "" >>  $FileTmp	
            echo "    }" >>  $FileTmp
		done
	done		
}

BuilderFunc()
{
    echo "" >> $FileTmp
    echo "    @Builder" >> $FileTmp
	echo "    public $ClassName($Builder) {" >> $FileTmp
    cat $BuilderTmp >> $FileTmp
	echo "    }" >> $FileTmp
}

#--- Mapping SQL and Java Data Types------------------------+
#+-----------------+----------------+-----------------------+
#|SQL data type    |Java data type                          | 
#+-----------------+----------------+-----------------------+
#|                 |Simply mappable | Object mappable       | 
#+-----------------+----------------+-----------------------+
#|CHARACTER        |                | String                |
#|VARCHAR          |                | String                |
#|LONGVARCHAR      |                | String                |
#|NUMERIC          |                | java.math.BigDecimal  |
#|DECIMAL          |                | java.math.BigDecimal  |
#|BIT              | boolean        | Boolean               |
#|TINYINT          | byte           | Integer               |
#|SMALLINT         | short          | Integer               |
#|INTEGER          | int            | Integer               |
#|BIGINT           | long           | Long                  |
#|REAL             | float          | Float                 |
#|FLOAT            | double         | Double                |
#|DOUBLE PRECISION | double         | Double                |
#|BINARY           |                | byte[]                |
#|VARBINARY        |                | byte[]                |
#|LONGVARBINARY    |                | byte[]                |
#|DATE             |                | java.sql.Date         |
#|TIME             |                | java.sql.Time         |
#|TIMESTAMP        |                | java.sql.Timestamp    |
#+-----------------+----------------+-----------------------+
ColumnProc()
{
    orgcol=`echo $1 | sed 's/\[//g' | sed 's/\]//g' | sed 's/\`//g'`
	Tolower $orgcol
    SnakeCaseToCamelCase $Result
    col=$Result
	Tolower $*
	datatype=$Result
	javatype=""
	identity=""
	GetComment $*
	comment=$Result

	case $datatype in
        /\**) 		 echo "----- $datatype" ;;	               # -- For Mysql DB 
	    *bit*)       javatype="Boolean";;
	#   *tinyint*)   javatype="short";;   
    #	*smalint*)   javatype="short";;
	#   *bigint*)    javatype="long" ;;
		*int*)       javatype="Integer" ;;
		*real*)      javatype="Float" ;;
		*float*)     javatype="Double" ;;
		*double*)    javatype="Double" ;;
		*binary*)    javatype="byte[]" ;;
	    *char*)      javatype="String" ;;
	    *numer*)     BigDecimal="T"; javatype="BigDecimal" ;;
		*money*)     BigDecimal="T"; javatype="BigDecimal" ;;
		*decimal*)   BigDecimal="T"; javatype="BigDecimal" ;;
		*timestamp*) Timestamp="T"; javatype="Timestamp" ;;
		*date*)      Date="T"; javatype="Date" ;;
		*time*)      Time="T"; javatype="Time" ;;
		*identity*)  javatype="Long" ; identity="T" ;;         # -- For H2 DB
        *)           echo "----- $datatype" ;;	
	esac	
	
	if [ "$javatype" == "" ]
	then
        return	
	fi
	# ------ Builder
	if [ "$FirstCol" == "" ]
	then 
	    FirstCol="T"
		echo "    @Id //  $javatype" >> $FileTmp
		if [ "$identity" == "T" ]                            # -- For H2 DB
		then
		      echo "    @GeneratedValue(strategy = GenerationType.AUTO)" >> $FileTmp
	    fi
	fi
	#elif [ "$Builder" == "" ]                               # Auto Incremental 은 향후 제외
	if [ "$identity" == "T" ]                                #-- For H2 DB
	then
	    xxx="skip"
	elif [ "$Builder" == "" ]
	then
	    Builder=`echo $javatype $col`
	    echo "        this.$col = $col;" >> $BuilderTmp
	else
	    Builder=`echo $Builder, $javatype $col`
	    echo "        this.$col = $col;" >> $BuilderTmp
    fi 
	# ------ Builder
	
	case $datatype in
	    *not?null*|*identity*) nullable="false" ;;
	    *) nullable="true" ;;
	esac
	
	echo "    @Column(name = \"$orgcol\", nullable = $nullable)" >> $FileTmp 
	echo "    private $javatype $col; $comment" >> $FileTmp
	echo "    private $javatype $col; $comment"
    echo "" >> $FileTmp
}

AnalReadLine()
{
   input=$*
   
   case $input in 
      *CREATE*TABLE*)
	      TableProc $input 
		  ;;
      \)?ON*|\)*)                #-- For H2 DB "|\)*"
	      GetComment `echo $* | sed 's/=/ /g' | sed 's/;/ /g'`
	      TableComment=$Result
	      BaseClass
		  BuilderFunc
		  PrePostFunc
		  cat $FileTmp | tee -a $FileName
	      ClassName="" 
          ClassAddLine "}"
          ClassAddLine ""		  
		  ;;
      *)
          if [ "$ClassName" != "" ]
          then
		      ColumnProc $input
          fi
		  ;;
   esac
}   

Initialize()
{
    if [ -d $BaseDir ]
	then
		rm -rf $BaseDir
	fi
    mkdir $BaseDir
}

main()
{
   Initialize
   
   while read line
   do
       AnalReadLine $line
   done < $1
   
   rm $BuilderTmp
}

if [ $# -ne 1 ]
then
    echo mssql jpa model base java generator
    echo usage : $0 create-sql-script-file-name
elif [ ! -f $1 ] 
then
    echo $1 '(create-sql-script-file-namecreate-sql-script-file-name) no exist!!'
else   
    main $1
fi
