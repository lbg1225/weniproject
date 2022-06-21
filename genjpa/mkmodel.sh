#!/bin/bash
#--------------------------------------------------------------
# DB Schema를 이용하여 JPA Entity Class를 생성하는 Script
#
# Created By SK Inc / Lee Byoung Gwan / lbg@sk.com / 2022-06-19
#--------------------------------------------------------------
BaseDir=tmp
ColTmp=col.tmp
FileTmp=file.tmp
FileTmpPK=filePK.tmp
BuilderTmp=builder.tmp
ClassName=
FileName=
FileNamePK=
Result=
Orgtable=
Table=

BigDecimal="F"
Date="F"
Time="F"
Timestamp="F"
Clob="F"
Blob="F"
IDENTITY="F"

BigDecimalPK="F"
DatePK="F"
TimePK="F"
TimestampPK="F"
ClobPK="F"
BlobPK="F"

Builder=
FirstCol=
TableComment=
PrimaryKeys=
PrimaryCnt=
pkFunc=
pkParam=

#--------------------------------------------------------------
# InitParam : Initialize Global Value
#--------------------------------------------------------------
InitParam()
{
    cat /dev/null > $FileTmp
	cat /dev/null > $FileTmpPK
   
    BigDecimal="F"
    Date="F"
    Time="F"
    Timestamp="F"
	Clob="F"
	Blob="F"

    BigDecimalPK="F"
    DatePK="F"
    TimePK="F"
    TimestampPK="F"
    ClobPK="F"
    BlobPK="F"
	IDENTITY="F"

	Builder=""
	FirstCol=""
	TableComment=""
	PrimaryKeys=""
    PrimaryCnt=0
	pkFunc=""
	pkParam=""
}

#--------------------------------------------------------------
# ClassAddLine : Append Parameter File
#--------------------------------------------------------------
ClassAddLine()
{
    echo $@ >> $FileName
}

#--------------------------------------------------------------
# ClassAddLinePK : Append Parameter PKFile
#--------------------------------------------------------------
ClassAddLinePK()
{
    echo $@ >> $FileNamePK
}

#--------------------------------------------------------------
# 문자열을 소문자로 치환
#--------------------------------------------------------------
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
    #-- ABC_1_DEF -> abc_1Def의 문제가 있어 sed 's/_//g' 추가
    Result=`echo $1 | sed -E 's/[ _-]([a-z])/\U\1/gi;s/^([A-Z])/\l\1/' | sed 's/_//g'`
}

#--------------------------------------------------------------
# Comment을 추출
#--------------------------------------------------------------
GetComment()
{
    flag=false;
	
    for arg in "$@"
    do 
	    case $arg in
		     comment|COMMENT) flag=true ;;
 		     *) if [ $flag ] ;	then  Result=`echo //--$arg | sed "s/'//g" | sed "s/,//"`; flag=false; fi		;;
	    esac	
    done	
}

#--------------------------------------------------------------
# Initialize 
#--------------------------------------------------------------
Initialize()
{
    if [ -d $BaseDir ]
	then
		rm -rf $BaseDir
	fi
    mkdir $BaseDir
}

#--------------------------------------------------------------
# CREATE TABLE dbo.TABLE( 문자열 처리
# Class명 및 파일명 생성
#--------------------------------------------------------------
TableProc()
{
    input=$*
	
	InitParam
	Orgtable=`echo $3 | sed 's/dbo\.//' | sed 's/(//'`
	Tolower $Orgtable
	SnakeCaseToCamelCase $Result
	ToupperFirst $Result
	
	Table=$Result
	ClassName=$Table
	FileName=$BaseDir/$ClassName.java
	FileNamePK=$BaseDir/$ClassName'PK'.java
	
	cat /dev/null > $FileName
	cat /dev/null > $FileNamePK
	cat /dev/null > $BuilderTmp
	cat /dev/null > $ColTmp
	
          
	# echo $ClassName
	# echo $FileName
}

#--------------------------------------------------------------
# GetColName : SnakeCase Column Name을 CamelCase로 변경
#--------------------------------------------------------------
GetColName()
{
    Tolower $1
    SnakeCaseToCamelCase $Result
}

#--------------------------------------------------------------
# AddIdClass : Generate IdClass
#--------------------------------------------------------------
AddIdClass()
{
    findFunc=`echo 'Page<'$ClassName'>findBy'$pkFunc'('$pkParam 'Pageable pageable);  // FindPK'| sed 's/And(/(/'`
    ClassAddLine '/*--------------------------------------------'
	ClassAddLine $findFunc
	ClassAddLine '  ------------------------------------------*/'
    ClassAddLine "@IdClass($ClassName"'PK.class)'
}


#--------------------------------------------------------------
# BaseClass : Generate base class
#--------------------------------------------------------------
BaseClass()
{	
    # ClassAddLine 'package com.weni.tmes.example.model;'
	if [ $BigDecimal == "T" ] ; then ClassAddLine 'import java.math.BigDecimal;'; fi
    if [ $Date == "T" ]       ; then ClassAddLine 'import java.sql.Date;'       ; fi
    if [ $Time == "T" ]       ; then ClassAddLine 'import java.sql.Time;'       ; fi
    if [ $Timestamp == "T" ]  ; then ClassAddLine 'import java.sql.Timestamp;'  ; fi
	if [ $Clob == "T" ]       ; then ClassAddLine 'import java.sql.Clob;'       ; fi
	if [ $Blob == "T" ]       ; then ClassAddLine 'import java.sql.Blob;'       ; fi
	#-- 불필요 ClassAddLine 'import java.io.Serializable;'
	# ClassAddLine 'import javax.persistence.*;'
	ClassAddLine 'import javax.persistence.Entity;'
    ClassAddLine 'import javax.persistence.Table;'
    ClassAddLine 'import javax.persistence.Id;'
    ClassAddLine 'import javax.persistence.Column;'
    ClassAddLine 'import javax.persistence.PostLoad;'
    ClassAddLine 'import javax.persistence.PrePersist;'
    ClassAddLine 'import javax.persistence.PostPersist;'
    ClassAddLine 'import javax.persistence.PreUpdate;'
    ClassAddLine 'import javax.persistence.PostUpdate;'
    ClassAddLine 'import javax.persistence.PreRemove;'
    ClassAddLine 'import javax.persistence.PostRemove;'
    if [ $IDENTITY == "T" ]
    then 
	    ClassAddLine 'import javax.persistence.GeneratedValue;' ; 
	    ClassAddLine 'import javax.persistence.GenerationType;' ; 
	fi
	if [ $PrimaryCnt -gt 1 ]; then ClassAddLine 'import javax.persistence.IdClass;' ; fi
    ClassAddLine '// import org.springframework.beans.BeanUtils;'
    # ClassAddLine 'import lombok.Data;'
    ClassAddLine 'import lombok.Getter;'
    ClassAddLine 'import lombok.NoArgsConstructor;'
    ClassAddLine 'import lombok.EqualsAndHashCode;'
    ClassAddLine 'import lombok.ToString;'
    ClassAddLine 'import lombok.Builder;'
	ClassAddLine ''
    ClassAddLine '@Entity'
    ClassAddLine "@Table(name=\"$Orgtable\")  $TableComment"
    ClassAddLine '@Getter'
    ClassAddLine '@NoArgsConstructor // (access = AccessLevel.PROTECTED) // AccessLevel.PUBLIC'
    ClassAddLine '@EqualsAndHashCode // (of = {"email","name"}, callSuper = true, onParam = @__(@NonNull))'  
	ClassAddLine '@ToString //(exclude = "password") // exclude 속성을 사용하면, 특정 필드를 toString() 결과에서 제외'
	if [ $PrimaryCnt -gt 1 ]; then	AddIdClass ; fi
	#-- 불필요ClassAddLine "public class $ClassName implements Serializable {"
	ClassAddLine "public class $ClassName {"
}

#--------------------------------------------------------------
# BaseClassPK :  Generate base primary-key class
#--------------------------------------------------------------
BaseClassPK()
{	
    if [ $BigDecimalPK == "T" ] ; then ClassAddLinePK 'import java.math.BigDecimal;'; fi
    if [ $DatePK == "T" ]       ; then ClassAddLinePK 'import java.sql.Date;'       ; fi
    if [ $TimePK == "T" ]       ; then ClassAddLinePK 'import java.sql.Time;'       ; fi
    if [ $TimestampPK == "T" ]  ; then ClassAddLinePK 'import java.sql.Timestamp;'  ; fi
	if [ $ClobPK == "T" ]       ; then ClassAddLinePK 'import java.sql.Clob;'       ; fi
	if [ $BlobPK == "T" ]       ; then ClassAddLinePK 'import java.sql.Blob;'       ; fi
	ClassAddLinePK 'import javax.persistence.Column;'
	ClassAddLinePK 'import java.io.Serializable;'
	ClassAddLinePK 'import lombok.Data;  //-- include @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode'
    ClassAddLinePK 'import lombok.NoArgsConstructor;'
    ClassAddLinePK 'import lombok.AllArgsConstructor;'
    ClassAddLinePK ''
    ClassAddLinePK '@Data'
    ClassAddLinePK '@NoArgsConstructor'
    ClassAddLinePK '@AllArgsConstructor'
	ClassAddLinePK "//-- $Orgtable $TableComment Primary Key"
	ClassAddLinePK "public class $ClassName"'PK implements Serializable {'
	ClassAddLinePK ''
    echo '    private static final long serialVersionUID = 1L;' >> $FileNamePK
    ClassAddLinePK ''
} 


#--------------------------------------------------------------
# PrePostFunc : Generate PerPost Function
#--------------------------------------------------------------
PrePostFunc()
{
    echo "" >> $FileTmp
	echo '    //----------------------------------------------------' >> $FileTmp
	echo '    // Load/Persist/Update/Remove(조회/신규/수정/삭제)' >> $FileTmp
	echo '    // Entity Pre/Post(이전/이후) 처리에 대한 정의(PreLoad는 없음)' >> $FileTmp
	echo '    // * DB의 Trigger와 비슷한 JPA기능' >> $FileTmp
	echo '    //----------------------------------------------------' >> $FileTmp
	for func in `echo Load Persist Update Remove`
	do
	    for gubun in `echo Pre Post`
		do   
            if [ $func == "Load" ] && [ $gubun == "Pre" ] ; then  continue ;	fi
	        echo "    @$gubun$func" >> $FileTmp
            echo "    public void on$gubun$func() {" >> $FileTmp
	        echo "" >>  $FileTmp	
            echo "    }" >>  $FileTmp
			echo "" >> $FileTmp
		done
	done		
}

#--------------------------------------------------------------
# BuilderFunc : Generate Builder Function
#--------------------------------------------------------------
BuilderFunc()
{
    echo "" >> $FileTmp
    echo "    @Builder" >> $FileTmp
	echo "    public $ClassName($Builder) {" >> $FileTmp
    cat $BuilderTmp >> $FileTmp
	echo "    }" >> $FileTmp
}

#--------------------------------------------------------------
# GetDataType : DB Type -> Java JPA Type
#+--------------+---------------+---------------+-------------+
#| Java Type    | DB Type       | Java Type     | DB Type     | 
#+--------------+---------------+---------------+-------------+
#| Byte         | tinyint(4)    | Date          | date        |  
#| Short        | smallint(6)   | Timestamp     | datetime    |  
#| Integer      | int(11)       | Time          | time        |  
#| Long         | bigint(20)    +---------------+-------------+
#| BigDecimal   | decimal(19,2) | String        | varchar(255)|
#| Float        | float         | Clob          | longtext    | 
#| Double       | double        | Byte[]        | tinyblob    | 
#| Boolean      | bit(1)        | Blob          | longblob    | 
#+--------------+---------------+---------------+-------------+
GetDataType()
{
    Result="";
	
    case $2 in
	   tinyint*)   Result='Byte'                        ;;
	   smallint*)  Result='Byte'                        ;;
	   tinyint*)   Result='Byte'                        ;; 
	   smallint*)  Result='Short'                       ;;
	   bigint*)    Result='Long'                        ;;
	   int*)       Result='Integer'                     ;;
	   numeric*)   Result='BigDecimal' ; BigDecimal="T" ;;
	   decimal*)   Result='BigDecimal' ; BigDecimal="T" ;;
	   float*)     Result='Float'                       ;;
	   double*)    Result='Double'                      ;;
	   bit*)       Result='Boolean'                     ;;
	   date*)      Result='Date'       ; Date="T"       ;;
	   datetime*)  Result='Timestamp'  ; Timestamp="T"  ;;
	   time*)      Result='Time'       ; Time="T"       ;;
	   nvarchar*)  Result='String'                      ;;
	   varchar*)   Result='String'                      ;;
	   char*)      Result='String'                      ;;
	   longtext*)  Result='Clob'       ; Clob="T"       ;;
	   tinyblob*)  Result='Byte[]'                      ;;
	   longblob*)  Result='Blob'       ; Blob="T"       ;;
	   identity*)  Result="Long"                        ;;   # // H2 DB
	   *) echo xxx
	esac
}

#--------------------------------------------------------------
# SetDataTypePK : PK Class import file extract
#--------------------------------------------------------------
SetDataTypePK()
{

    case $* in
	   BigDecimal) BigDecimalPK="T" ;;
	   Date)       DatePK="T"       ;;
	   Timestamp)  TimestampPK="T"  ;;
	   Time)       TimePK="T"       ;;
	   Clob)       ClobPK="T"       ;;
	   Blob)       BlobPK="T"       ;;
	esac
}

#--------------------------------------------------------------
# IsNullable : Column is nullable
#--------------------------------------------------------------
IsNullable()
{
    Result="true";
	
    case $* in
	   *not?null* |*primary?key*)      Result='false'     ;;
    esac
}

#--------------------------------------------------------------
# IsIdentity : Column is Identity or auto_increment
#--------------------------------------------------------------
IsIdentity()
{
    Result="F";
	
	case $* in
	   *auto_increment*|*identity*) Result='T' ; IDENTITY='T' ;;
    esac
}

#--------------------------------------------------------------
# IsPrimary : Column is Primary
#--------------------------------------------------------------
IsPrimary()
{
    Result="F";
	
    case $* in
	   *primary?key*)      Result='T'     ;;
    esac
}

#--------------------------------------------------------------
# GetColSize : Column의 size정보을 추출
#--------------------------------------------------------------
GetColSize()
{
	Result='F'
    case $1 in
	*int*) ;;    #-- Mysql Bigint(20)
	*\(*\)*) 
	    data=(`echo $1 | sed 's/(/ /g' | sed 's/)//g'`);
		Result=${data[1]};
		;;
    esac
}

#--------------------------------------------------------------
# ColumnProc : 컬럼정보 추출
#--------------------------------------------------------------
ColumnProc()
{
    #-- Parameter lower case transfer
	Tolower $*
	param=$Result
	
    #-- 1. DB Column Name
    orgcol=`echo $1 | sed 's/\[//g' | sed 's/\]//g' | sed 's/\`//g'`
	
	#-- 2. DB Column Name -> Java Column Name (DEPT_CODE -> deptCode)
	GetColName $orgcol
    col=$Result
    
	#-- 3. DB Type -> Java Type 
	GetDataType $param
	javatype=$Result
	
	#-- 4. nullable
	IsNullable $param
	nullable=$Result
	
	#-- 5. Identity
	IsIdentity $param
	identity=$Result
	
	#-- 6. Primary
	IsPrimary $param
	primary=$Result
	
	#-- 7. Comment
	GetComment $param
	comment=$Result

	#-- 8. ColSize
	if [ `echo $2 | grep numeric | wc -l` -eq 1 ]
	then
	    GetColSize $2$3   
    else
	    GetColSize $2
	fi
	
	colsize=$Result

	if [ "$javatype" != "" ]
	then
	    echo $orgcol $col $javatype $nullable $identity $primary $comment $colsize >> $ColTmp
	fi
}

#--------------------------------------------------------------
# GenFindPk : Generate Find Primary Key Function 
#--------------------------------------------------------------
GenFindPk()
{
    param=`echo $pkParam $1 $2,`
	pkParam=$param
	
	ToupperFirst $2
	func=`echo $pkFunc$Result'And'`
	pkFunc=$func
   
}

#--------------------------------------------------------------
# GenFileTmp : Generate Model Tmp File
#--------------------------------------------------------------
GenFileTmp()
{
    orgcol=$1
    col=$2
	javatype=$3 
	nullable=$4 
	identity=$5 
	primary=$6
	comment=$7
	colsize=$8
	
	IdCol=`echo " $PrimaryKeys " | grep " $orgcol " | wc -l`
	
	if [ "$FirstCol" == "" ] || [ "$identity" == "T" ] || [ "$primary" == "T" ] || [ $IdCol -gt 0 ]
	then 
	    FirstCol="T"
		echo "    @Id //  $javatype" >> $FileTmp
	fi
	
	if [ "$identity" == "T" ]                            # -- For H2 DB
	then
		 echo "    @GeneratedValue(strategy = GenerationType.AUTO)" >> $FileTmp
	elif [ "$Builder" == "" ]
	then
	    Builder=`echo $javatype $col`
	    echo "        this.$col = $col;" >> $BuilderTmp
	else
	    Builder=`echo $Builder, $javatype $col`
	    echo "        this.$col = $col;" >> $BuilderTmp
    fi 
	
	if [ $colsize == "F" ]
	then
	    columndt="@Column(name = \"$orgcol\", nullable = $nullable)"
	    echo "    $columndt" >> $FileTmp 
	elif [ $javatype == "BigDecimal" ]
	then
	    tmpdt=(`echo $colsize | sed 's/,/ /g'`)
	    columndt="@Column(name = \"$orgcol\", precision = ${tmpdt[0]}, scale = ${tmpdt[1]}, nullable = $nullable)"
	    echo "    $columndt" >> $FileTmp 
	else
	    columndt="@Column(name = \"$orgcol\", length = $colsize, nullable = $nullable)"
	    echo "    $columndt" >> $FileTmp 
	fi
	
	echo "    private $javatype $col; $comment" >> $FileTmp
	echo "" >> $FileTmp
	
	if [ $PrimaryCnt -gt 1 ] && [ $IdCol -gt 0 ]
	then
	    GenFindPk $javatype $col
		SetDataTypePK $javatype
	    echo "    $columndt" >> $FileTmpPK
	    echo "    private $javatype $col; $comment" >> $FileTmpPK
		echo "" >> $FileTmpPK
	fi
}

#--------------------------------------------------------------
# GenModel : Generate Model File
#--------------------------------------------------------------
GenModel()
{
    while read line
    do
        GenFileTmp $line
    done < $ColTmp
    
    GetComment `echo $* | sed 's/=/ /g' | sed 's/;/ /g'`
    TableComment=$Result
    BaseClass
    BuilderFunc
    PrePostFunc
    cat $FileTmp >> $FileName
    ClassAddLine "}"
    ClassAddLine ""
    
    if [ $PrimaryCnt -gt 1 ]
    then
        BaseClassPK
        cat $FileTmpPK >> $FileNamePK
        ClassAddLinePK "}"
        ClassAddLinePK ""   
	else 
	    rm $FileNamePK
    fi
	
    ClassName="" 	
}

#--------------------------------------------------------------
# AnalReadLine : DB Schema Read & Generate Model File
#--------------------------------------------------------------
AnalReadLine()
{
   input=`echo $* | sed 's/\[//g' | sed 's/\]//g' | sed 's/\`//g'`
   
   case $input in  
      /\**|--*|"DROP TABLE*"|"SET *"|"GO"|FOREIGN*)   
	      ;;
      *CREATE*TABLE*)  
	      TableProc $input 
		  echo '-----------------------------------------------------'	
		  echo "$Orgtable Generating ["`date +%T`"]"
		  ;;
	  PRIMARY?KEY*)
	      PrimaryKeys=`echo $input | sed 's/PRIMARY KEY (/ /' | sed 's/)/ /' |sed 's/,/ /g' | sed 's/\`//g'`
		  PrimaryCnt=`echo $PrimaryKeys | wc -w`
		  ;;
	  \)?ON*|\)*)  
	      GenModel $input
          echo "$Orgtable Generated  ["`date +%T`"]"
		  ;; 
	  *)           
	      if [ "$ClassName" != "" ] ; then ColumnProc $input ; fi 
		  ;;
   esac
} 

#--------------------------------------------------------------
# AnalReadLine : DB Schema To Generate Model File
#--------------------------------------------------------------
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
    echo jpa model base java source generator
    echo usage : $0 create-sql-script-file-name
elif [ ! -f $1 ] 
then
    echo $1 '(create-sql-script-file-namecreate-sql-script-file-name) no exist!!'
else   
    main $1
fi
