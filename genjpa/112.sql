USE [TMDB]
GO
/****** Object:  Table [dbo].[EDU_ACNT]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EDU_ACNT](
	[ACNT_NO] [int] NOT NULL,
	[BALANCE] [numeric](18, 0) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EDU_HIST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EDU_HIST](
	[ACNT_NO] [int] NOT NULL,
	[TX_TIMESTAMP] [datetime] NOT NULL,
	[TYPE] [varchar](50) NULL,
	[AMOUNT] [numeric](18, 0) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[H_CALL_IF_HIST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[H_CALL_IF_HIST](
	[HIST_SEQ_NUM] [int] NOT NULL,
	[PCALL_STRT_DAYTIME] [datetime] NULL,
	[PCALL_CLOSE_DAYTIME] [datetime] NULL,
	[PCALL_LEN] [int] NULL,
	[NUMBMKCALL_YN] [char](1) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[CTI_USR_ID] [varchar](30) NULL,
	[CALL_ID] [varchar](20) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[H_CHANGE_HIST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[H_CHANGE_HIST](
	[CHANGE_SEQ_NUM] [int] NOT NULL,
	[RECPT_NUM] [int] NOT NULL,
	[USR_ID] [varchar](30) NULL,
	[CHANGE_DIV] [varchar](1) NULL,
	[CHANGE_ITEM] [nvarchar](200) NULL,
	[PRE_DATA] [nvarchar](4000) NULL,
	[AFTER_DATA] [nvarchar](4000) NULL,
	[CHANGEPERSN_ID] [varchar](30) NOT NULL,
	[CHANGE_TM] [datetime] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[H_NOTFC_MKCALL_HIST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[H_NOTFC_MKCALL_HIST](
	[MKCALL_SEQ_NUM] [int] NOT NULL,
	[SENDPERSN_ID] [varchar](30) NOT NULL,
	[INCID_NUM] [varchar](60) NULL,
	[INCID_OVIEW] [nvarchar](4000) NULL,
	[INDIC_ITM] [nvarchar](4000) NOT NULL,
	[SEND_TM] [datetime] NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[H_NOTFC_RECV_HIST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[H_NOTFC_RECV_HIST](
	[MKCALL_SEQ_NUM] [int] NOT NULL,
	[USR_ID] [varchar](30) NOT NULL,
	[RECV_TM] [datetime] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[H_SMS_MKCALL_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[H_SMS_MKCALL_INFO](
	[MKCALL_SEQ_NUM] [int] NOT NULL,
	[MDT_DEV_ID] [int] NOT NULL,
	[MSG_NUM] [smallint] NULL,
	[INDIC_ITM] [nvarchar](140) NOT NULL,
	[CALLER_ID] [varchar](30) NOT NULL,
	[RECPT_TM] [datetime] NOT NULL,
	[MKCALL_TM] [datetime] NULL,
	[RECV_TM] [datetime] NULL,
	[CFM_TM] [datetime] NULL,
	[MKCALL_STT] [varchar](1) NOT NULL,
	[SEND_RSLT] [nvarchar](200) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[I_DISP_FAC_CURR]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[I_DISP_FAC_CURR](
	[MDT_DEV_ID] [int] NOT NULL,
	[LGT] [float] NULL,
	[LTT] [float] NULL,
	[STT] [varchar](1) NULL,
	[COLL_TM] [datetime] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[I_DISP_FAC_HIST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[I_DISP_FAC_HIST](
	[MDT_DEV_ID] [int] NOT NULL,
	[COLL_TM] [datetime] NOT NULL,
	[LGT] [float] NULL,
	[LTT] [float] NULL,
	[STT] [varchar](1) NULL,
	[TRANSMIT_PRD] [int] NULL,
	[JURIS_CODE] [varchar](20) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[I_EXTN_IF_RSLT]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[I_EXTN_IF_RSLT](
	[REQ_ID] [varchar](30) NOT NULL,
	[REQ_INFO] [nvarchar](4000) NULL,
	[REQ_TM] [varchar](30) NULL,
	[RSLT_MSG] [nvarchar](4000) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[I_EXTN_IF_SCKT]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[I_EXTN_IF_SCKT](
	[SER_NUM] [varchar](20) NULL,
	[REQ_ID] [varchar](30) NULL,
	[PROXY_TYPE] [varchar](10) NULL,
	[HOST] [varchar](20) NULL,
	[PORT] [int] NULL,
	[SEND_MSG] [nvarchar](4000) NULL,
	[SYNC_YN] [bit] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[J_JURIS_AGCY]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[J_JURIS_AGCY](
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[JURIS_CODE] [varchar](20) NOT NULL,
	[JURIS_MNG_CODE] [varchar](20) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[J_USR_GRP_MNU]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[J_USR_GRP_MNU](
	[USR_GRP_ID] [varchar](50) NOT NULL,
	[MNU_ID] [varchar](50) NOT NULL,
	[QRY_FLAG] [varchar](1) NULL,
	[UPT_FLAG] [varchar](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[J_USR_GRP_RELATD_BUSN]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[J_USR_GRP_RELATD_BUSN](
	[USR_GRP_ID] [varchar](50) NOT NULL,
	[BUSN] [varchar](20) NOT NULL,
	[JURIS_FLAG] [varchar](1) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[J_USR_MNU]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[J_USR_MNU](
	[USR_ID] [varchar](30) NOT NULL,
	[MNU_ID] [varchar](50) NOT NULL,
	[QRY_FLAG] [varchar](1) NULL,
	[UPT_FLAG] [varchar](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[J_USR_ROLE]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[J_USR_ROLE](
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[ROLE_CODE] [varchar](20) NOT NULL,
	[EDIT_CODE] [varchar](20) NULL,
	[ROLE_KND] [varchar](20) NOT NULL,
	[USR_ID] [varchar](30) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_ADDR_BLDG]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_ADDR_BLDG](
	[BLDG_CODE] [varchar](24) NOT NULL,
	[ADDR_ALL_CODE] [varchar](9) NOT NULL,
	[ROAD_SECT_CODE] [varchar](7) NOT NULL,
	[MAIN_HS_NUM] [varchar](4) NULL,
	[SUB_HS_NUM] [varchar](4) NULL,
	[BLDG_NM] [nvarchar](200) NULL,
	[LGT] [float] NULL,
	[LTT] [float] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_ADDR_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_ADDR_INFO](
	[ADDR_ALL_CODE] [varchar](9) NOT NULL,
	[LVL] [varchar](1) NULL,
	[ADDR_STATE_CODE] [varchar](2) NULL,
	[ADDR_CITY_CODE] [varchar](3) NULL,
	[ADDR_DISTRICT_CODE] [varchar](4) NULL,
	[ADDR_ALL_NM] [nvarchar](500) NULL,
	[ADDR_STATE_NM] [nvarchar](100) NULL,
	[ADDR_CITY_NM] [nvarchar](100) NULL,
	[ADDR_DISTRICT_NM] [nvarchar](100) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_ADDR_ROAD_SECT]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_ADDR_ROAD_SECT](
	[ROAD_SECT_CODE] [varchar](7) NOT NULL,
	[ROAD_SECT_NM] [nvarchar](200) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_BLDG]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_BLDG](
	[BLDG_CODE] [varchar](24) NOT NULL,
	[BLDG_NM] [nvarchar](200) NULL,
	[ADDR_STATE] [nvarchar](100) NULL,
	[ADDR_FCITY] [nvarchar](100) NULL,
	[ADDR_WARD] [nvarchar](100) NULL,
	[ADDR_DISTRICT] [nvarchar](100) NULL,
	[ADDR_DIST] [nvarchar](100) NULL,
	[ADDR_HS_NUM] [nvarchar](100) NULL,
	[ADDR_APT_DISTRICT] [nvarchar](30) NULL,
	[LGT] [float] NULL,
	[LTT] [float] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[BLDG_GB_CODE] [nvarchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_BLDG_DTL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_BLDG_DTL](
	[BLDG_CODE] [varchar](24) NOT NULL,
	[BLDG_OVIEW] [nvarchar](2000) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_BLDG_FILE_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_BLDG_FILE_INFO](
	[BLDG_FILE_FOLD] [nvarchar](200) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[BLDG_FILE_NM] [nvarchar](200) NOT NULL,
	[BLDG_FILE_TYPE_CODE] [varchar](20) NULL,
	[BLDG_FILE_FLOOR_CODE] [varchar](20) NULL,
	[BLDG_CODE] [varchar](24) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_BTN_ROLE]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_BTN_ROLE](
	[BTN_ROLE_CODE] [varchar](20) NOT NULL,
	[BTN_ROLE_NM] [nvarchar](100) NOT NULL,
	[DEL_FLAG] [varchar](1) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[BTN_ROLE_NM_RUS] [nvarchar](100) NOT NULL,
	[BTN_ROLE_NM_KOR] [nvarchar](100) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_CLSSFY_CODE_GET_NUM]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_CLSSFY_CODE_GET_NUM](
	[GET_NUM_CODE] [varchar](20) NOT NULL,
	[JURIS_MNG_CODE] [varchar](20) NULL,
	[MNG_JNL_CLSSFY_CODE] [varchar](30) NULL,
	[ETC_INCID_MNG_CODE] [varchar](30) NULL,
	[FINAL_MNG_JNL_NUM] [varchar](40) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_CMNCODE]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_CMNCODE](
	[CLSSFY_CODE] [varchar](20) NOT NULL,
	[CLSSFY_NM] [nvarchar](100) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[CLSSFY_NM_KOR] [nvarchar](100) NULL,
	[CLSSFY_NM_RUS] [nvarchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_CMNCODE_DTL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_CMNCODE_DTL](
	[CLSSFY_DTL_CODE] [varchar](30) NOT NULL,
	[CLSSFY_CODE] [varchar](20) NOT NULL,
	[CLSSFY_DTL_NM] [nvarchar](100) NULL,
	[CLSSFY_1] [varchar](30) NULL,
	[CLSSFY_2] [varchar](30) NULL,
	[CLSSFY_3] [varchar](30) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[CLSSFY_DTL_NM_KOR] [nvarchar](100) NULL,
	[CLSSFY_DTL_NM_RUS] [nvarchar](100) NULL,
	[CLSSFY_DTL_EXP] [nvarchar](4000) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_CTRY]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_CTRY](
	[CTRY_CODE_3] [varchar](3) NOT NULL,
	[CTRY_CODE_2] [varchar](2) NULL,
	[CTRY_NM] [nvarchar](100) NULL,
	[CTRY_ABBR_NM] [nvarchar](100) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_DISP_FAC]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_DISP_FAC](
	[MDT_DEV_ID] [int] NOT NULL,
	[JURIS_CODE] [varchar](20) NOT NULL,
	[ICON] [nvarchar](200) NOT NULL,
	[MDT_DEV_NM] [nvarchar](50) NOT NULL,
	[TRANSMIT_PRD] [int] NULL,
	[CURR_EXIST_STT] [varchar](1) NOT NULL,
	[DEL_FLAG] [varchar](1) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_EDIT_ROLE]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_EDIT_ROLE](
	[EDIT_ROLE_CODE] [varchar](20) NOT NULL,
	[EDIT_ROLE_NM] [nvarchar](100) NOT NULL,
	[DEL_FLAG] [varchar](1) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[EDIT_ROLE_NM_RUS] [nvarchar](100) NOT NULL,
	[EDIT_ROLE_NM_KOR] [nvarchar](100) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_INCID_TYPE]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_INCID_TYPE](
	[INCIDTYPE_BIGCLSSFY_CODE] [varchar](30) NOT NULL,
	[INCIDTYPE_MEDCLSSFY_CODE] [varchar](30) NOT NULL,
	[INCIDTYPE_SMALLCLSSFY_CODE] [varchar](30) NOT NULL,
	[CLSSFY_LVL] [char](1) NULL,
	[INCIDTYPE_BIGCLSSFY_NM] [nvarchar](100) NULL,
	[INCIDTYPE_MEDCLSSFY_NM] [nvarchar](100) NULL,
	[INCIDTYPE_SMALLCLSSFY_NM] [nvarchar](100) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[INCIDTYPE_BIGCLSSFY_NM_KOR] [nvarchar](100) NULL,
	[INCIDTYPE_MEDCLSSFY_NM_KOR] [nvarchar](100) NULL,
	[INCIDTYPE_SMALLCLSSFY_NM_KOR] [nvarchar](100) NULL,
	[INCIDTYPE_BIGCLSSFY_NM_RUS] [nvarchar](100) NULL,
	[INCIDTYPE_MEDCLSSFY_NM_RUS] [nvarchar](100) NULL,
	[INCIDTYPE_SMALLCLSSFY_NM_RUS] [nvarchar](100) NULL,
	[INCIDTYPE_EXP] [nvarchar](4000) NULL,
	[INCIDTYPE_BG_COLOR] [nvarchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_JURIS_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_JURIS_INFO](
	[JURIS_CODE] [varchar](20) NOT NULL,
	[JURIS_NM] [nvarchar](300) NULL,
	[BUSN] [varchar](20) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[JURIS_NM_KOR] [nvarchar](300) NULL,
	[JURIS_NM_RUS] [nvarchar](300) NULL,
	[LGT] [float] NULL,
	[LTT] [float] NULL,
	[DEL_FLAG] [varchar](1) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_JURIS_MNG_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_JURIS_MNG_INFO](
	[JURIS_MNG_CODE] [varchar](20) NOT NULL,
	[JURIS_MNG_NM] [nvarchar](300) NULL,
	[JURIS_MNG_NM_KOR] [nvarchar](300) NULL,
	[JURIS_MNG_NM_RUS] [nvarchar](300) NULL,
	[JURIS_MNG_ABBR_NM] [nvarchar](20) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[DEL_FLAG] [varchar](1) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_LABL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_LABL](
	[ID] [varchar](50) NOT NULL,
	[GRP_LABL_ID] [varchar](20) NULL,
	[LABL_ID] [varchar](20) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_MNU_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_MNU_INFO](
	[MNU_ID] [varchar](50) NOT NULL,
	[BUSN_DOMAIN] [nvarchar](150) NULL,
	[BUSN_SKILL] [nvarchar](400) NULL,
	[SCR_NM] [nvarchar](300) NULL,
	[SCR_EXP] [nvarchar](500) NULL,
	[DEL_FLAG] [varchar](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[SCR_NM_KOR] [nvarchar](300) NULL,
	[SCR_NM_RUS] [nvarchar](300) NULL,
	[LST_NUMB] [int] NULL,
	[QRY_SEQ] [int] NOT NULL,
	[QRY_FLAG] [varchar](1) NULL,
	[UPT_FLAG] [varchar](1) NULL,
	[INS_FLAG] [varchar](1) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_QSTN_LST]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_QSTN_LST](
	[QSTN_ID] [varchar](20) NOT NULL,
	[INCIDTYPE_BIGCLSSFY_CODE] [varchar](30) NOT NULL,
	[INCIDTYPE_MEDCLSSFY_CODE] [varchar](30) NOT NULL,
	[INCIDTYPE_SMALLCLSSFY_CODE] [varchar](30) NOT NULL,
	[QSTN_CONT] [nvarchar](4000) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_RELATD_BUSN]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_RELATD_BUSN](
	[BUSN] [varchar](20) NOT NULL,
	[BUSN_NM] [nvarchar](100) NOT NULL,
	[BUSN_NM_RUS] [nvarchar](100) NOT NULL,
	[BUSN_NM_KOR] [nvarchar](100) NOT NULL,
	[DEL_FLAG] [varchar](1) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_USR_GRP]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_USR_GRP](
	[USR_GRP_ID] [varchar](50) NOT NULL,
	[USR_GRP_NM] [nvarchar](100) NULL,
	[USR_GRP_NM_KOR] [nvarchar](100) NULL,
	[USR_GRP_NM_RUS] [nvarchar](100) NULL,
	[BUSN_FLAG] [varchar](1) NULL,
	[NOTFC_FLAG] [varchar](1) NULL,
	[QTY_SEQ] [int] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[M_USR_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[M_USR_INFO](
	[USR_ID] [varchar](30) NOT NULL,
	[JURIS_CODE] [varchar](20) NULL,
	[OFF_RANK_CODE] [varchar](10) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[PWD] [varchar](40) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[LOCALE_CODE] [varchar](20) NULL,
	[CURR_EXIST_STT] [nvarchar](1) NULL,
	[SOFTPHONE_NUM] [varchar](6) NULL,
	[LOGIN_KEEP_TM] [numeric](10, 0) NULL,
	[GIS_USR_GRP] [varchar](30) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_DISP_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_DISP_INFO](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[DISP_CMD_TM] [datetime] NULL,
	[DISP_STRT_TM] [datetime] NULL,
	[DISP_CLOSE_TM] [datetime] NULL,
	[MDT_DEV_ID] [int] NOT NULL,
	[DISP_PRCS_INSP_ID] [varchar](30) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_DISP_INFO_TMP]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_DISP_INFO_TMP](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[DISP_CMD_TM] [datetime] NULL,
	[DISP_STRT_TM] [datetime] NULL,
	[DISP_CLOSE_TM] [datetime] NULL,
	[MDT_DEV_ID] [int] NOT NULL,
	[DISP_PRCS_INSP_ID] [varchar](30) NOT NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD](
	[RECPT_NUM] [int] NOT NULL,
	[RECPT_DIV] [varchar](1) NULL,
	[INCID_NUM] [varchar](60) NULL,
	[SAME_INCID_NUM] [varchar](60) NULL,
	[CALLER_RGNNUM] [varchar](10) NULL,
	[CALLER_PHONNUM] [varchar](20) NULL,
	[WIRENLESS_DIV] [varchar](1) NULL,
	[CALLER_FLNAME] [nvarchar](200) NULL,
	[CALLER_PASS_NUM] [nvarchar](300) NULL,
	[CALLER_FCITY] [nvarchar](200) NULL,
	[CALLER_DISTRICT] [nvarchar](100) NULL,
	[CALLER_DIST] [nvarchar](60) NULL,
	[CALLER_HS_NUM] [nvarchar](50) NULL,
	[CALLER_APT_DISTRICT] [nvarchar](20) NULL,
	[CALLER_APT_KVARTIR] [nvarchar](20) NULL,
	[CALLER_BLDG_CODE] [varchar](24) NULL,
	[CALLER_ALL_ADDR] [nvarchar](300) NULL,
	[CALLER_LGT] [float] NULL,
	[CALLER_LTT] [float] NULL,
	[CALLER_AGCY_KND] [varchar](30) NULL,
	[CALLER_AGCY_NM] [nvarchar](200) NULL,
	[REPRTPERSN_NAT] [varchar](30) NULL,
	[REPRTPERSN_FAM_NM] [nvarchar](100) NULL,
	[REPRTPERSN_GIV_NM] [nvarchar](100) NULL,
	[REPRTPERSN_MID_NM] [nvarchar](200) NULL,
	[REPRTPERSN_BIRTHYEARMMDD] [datetime] NULL,
	[REPRTPERSN_TPHONE] [varchar](20) NULL,
	[REPRTPERSN_HP] [varchar](20) NULL,
	[REPRTPERSN_PASS_NUM] [nvarchar](120) NULL,
	[REPRTPERSN_FCITY] [nvarchar](100) NULL,
	[REPRTPERSN_DISTRICT] [nvarchar](100) NULL,
	[REPRTPERSN_DIST] [nvarchar](100) NULL,
	[REPRTPERSN_HS_NUM] [nvarchar](100) NULL,
	[REPRTPERSN_APT_DISTRICT] [nvarchar](30) NULL,
	[REPRTPERSN_APT_KVARTIR] [nvarchar](30) NULL,
	[REPRTPERSN_FORGNR_FCITY] [nvarchar](100) NULL,
	[REPRTPERSN_FORGNR_DIST] [nvarchar](100) NULL,
	[REPRTPERSN_FORGNR_HS_NUM] [nvarchar](100) NULL,
	[REPRTPERSN_FORGNR_KVARTIR] [nvarchar](30) NULL,
	[REPRTPERSN_OFF_RANK] [nvarchar](50) NULL,
	[REPRTPERSN_DEPT] [nvarchar](100) NULL,
	[INCIDOCR_FCITY] [nvarchar](100) NULL,
	[INCIDOCR_DISTRICT] [nvarchar](100) NULL,
	[INCIDOCR_DIST] [nvarchar](100) NULL,
	[INCIDOCR_HS_NUM] [nvarchar](100) NULL,
	[INCIDOCR_APT_DISTRICT] [nvarchar](30) NULL,
	[INCIDOCR_APT_KVARTIR] [nvarchar](30) NULL,
	[INCIDOCR_BLDG] [nvarchar](200) NULL,
	[INCIDTYPE_BIGCLSSFY_CODE] [varchar](30) NULL,
	[INCIDTYPE_MEDCLSSFY_CODE] [varchar](30) NULL,
	[INCIDTYPE_SMALLCLSSFY_CODE] [varchar](30) NULL,
	[INCIDOCR_TM] [datetime] NULL,
	[INCIDOCR_LGT] [float] NULL,
	[INCIDOCR_LTT] [float] NULL,
	[INCIDOCR_BLDG_CODE] [varchar](24) NULL,
	[RELATDBUSN_FIRE_FLAG] [varchar](1) NULL,
	[RELATDBUSN_POL_FLAG] [varchar](1) NULL,
	[RELATDBUSN_TRFC_POL_FLAG] [varchar](1) NULL,
	[JURIS_CODE] [varchar](20) NULL,
	[INCID_OVIEW] [nvarchar](4000) NULL,
	[RECPTPERSN_ID] [varchar](30) NULL,
	[RECPT_REPRT_TM] [datetime] NULL,
	[RECPT_CLOSE_TM] [datetime] NULL,
	[REPRTPERSN_HANDWR_STT] [varchar](1) NULL,
	[PRCS_STT] [varchar](2) NULL,
	[ENDPRCS_TM] [datetime] NULL,
	[NPRCSD_INSP_ID] [varchar](30) NULL,
	[END_PRCS_INSP_ID] [varchar](30) NULL,
	[MNG_JNL_CLSSFY_CODE] [varchar](30) NULL,
	[ETC_INCID_MNG_CODE] [varchar](30) NULL,
	[MNG_JNL_NUM] [varchar](40) NULL,
	[INSP_FAM_NM] [nvarchar](200) NULL,
	[DISP_NEED_PERSN] [nvarchar](4000) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[JURIS_MNG_CODE] [varchar](20) NULL,
	[NPRCSD_CLOSE_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_FIRE]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_FIRE](
	[RECPT_NUM] [int] NOT NULL,
	[FIRE_FST_DISP_TM] [datetime] NULL,
	[FIRE_FIELD_ARRV_TM] [datetime] NULL,
	[FIRE_SPRAY_WAT_STRT_TM] [datetime] NULL,
	[FIRE_AFIRE_TRGT_CODE] [varchar](30) NULL,
	[FIRE_AFIRE_SPRD_RISK_FLAG] [varchar](1) NULL,
	[FIRE_DAMAGEPERSN_OCR_RISK_FLAG] [varchar](1) NULL,
	[FIRE_BLDG_COLLAPSE_RISK_FLAG] [varchar](1) NULL,
	[FIRE_ADD_REQ_FIRECAR_NUMB] [int] NULL,
	[FIRE_ADD_REQ_FFIGHTER_NUMB] [int] NULL,
	[FIRE_ADD_REQ_EQU_NUMB] [int] NULL,
	[FIRE_AFIRE_GRD_CODE] [varchar](30) NULL,
	[FIRE_L10N] [datetime] NULL,
	[FIRE_AFIRE_CLOSE_TM] [datetime] NULL,
	[FIRE_FIRECAR_RTN_TM] [datetime] NULL,
	[FIRE_FST_FIRECAR_NUMB] [int] NULL,
	[FIRE_AFIRE_RESN_CODE] [varchar](30) NULL,
	[FIRE_DISP_PTCL_VEHICLE] [nvarchar](200) NULL,
	[FIRE_CCND_AGCY_SPRT_REQ_ITM] [nvarchar](4000) NULL,
	[FIRE_LOSS_DESC] [nvarchar](4000) NULL,
	[FIRE_LOSS_AMOUNT] [int] NULL,
	[FIRE_THREPRT_EXCLUDE_FLAG] [varchar](1) NULL,
	[FIRE_LOSS_AMOUNT_EXCLUDE_FLAG] [varchar](1) NULL,
	[FIRE_ADDITM] [nvarchar](4000) NULL,
	[BLDG_PROPRTR] [nvarchar](200) NULL,
	[AFIRE_SIZE] [int] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_FIRE_DTL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_FIRE_DTL](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[CTRY_CODE_3] [varchar](30) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[BIRTHYEARMMDD] [datetime] NULL,
	[TPHONE] [varchar](20) NULL,
	[HP] [varchar](20) NULL,
	[PASS_NUM] [nvarchar](120) NULL,
	[DOMPERS_FCITY] [nvarchar](100) NULL,
	[DOMPERS_DISTRICT] [nvarchar](100) NULL,
	[DOMPERS_DIST] [nvarchar](100) NULL,
	[DOMPERS_HS_NUM] [nvarchar](100) NULL,
	[DOMPERS_APT_DISTRICT] [nvarchar](30) NULL,
	[DOMPERS_APT_KVARTIR] [nvarchar](30) NULL,
	[FORGNR_FCITY] [nvarchar](100) NULL,
	[FORGNR_DIST] [nvarchar](100) NULL,
	[FORGNR_HS_NUM] [nvarchar](100) NULL,
	[FORGNR_KVARTIR] [nvarchar](30) NULL,
	[SEX_CODE] [varchar](30) NULL,
	[FAM_REL_CODE] [varchar](30) NULL,
	[CRIM_REC] [nvarchar](150) NULL,
	[WRK_PLACE_NM] [nvarchar](200) NULL,
	[INJURY_KND_CODE] [varchar](30) NULL,
	[INJURY_GRD_CODE] [varchar](30) NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[HANDWR_STT] [char](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_FIRE_DTL_TMP]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_FIRE_DTL_TMP](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[CTRY_CODE_3] [varchar](30) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[BIRTHYEARMMDD] [datetime] NULL,
	[TPHONE] [varchar](20) NULL,
	[HP] [varchar](20) NULL,
	[PASS_NUM] [nvarchar](120) NULL,
	[DOMPERS_FCITY] [nvarchar](100) NULL,
	[DOMPERS_DISTRICT] [nvarchar](100) NULL,
	[DOMPERS_DIST] [nvarchar](100) NULL,
	[DOMPERS_HS_NUM] [nvarchar](100) NULL,
	[DOMPERS_APT_DISTRICT] [nvarchar](30) NULL,
	[DOMPERS_APT_KVARTIR] [nvarchar](30) NULL,
	[FORGNR_FCITY] [nvarchar](100) NULL,
	[FORGNR_DIST] [nvarchar](100) NULL,
	[FORGNR_HS_NUM] [nvarchar](100) NULL,
	[FORGNR_KVARTIR] [nvarchar](30) NULL,
	[SEX_CODE] [varchar](30) NULL,
	[FAM_REL_CODE] [varchar](30) NULL,
	[CRIM_REC] [nvarchar](150) NULL,
	[WRK_PLACE_NM] [nvarchar](200) NULL,
	[INJURY_KND_CODE] [varchar](30) NULL,
	[INJURY_GRD_CODE] [varchar](30) NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[HANDWR_STT] [char](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_POL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_POL](
	[RECPT_NUM] [int] NOT NULL,
	[POL_INCIDOVIEW] [nvarchar](4000) NULL,
	[POL_POSS_CRIME_TRGT] [nvarchar](4000) NULL,
	[POL_LOSSAMOUNT] [int] NULL,
	[POL_VALUTA_CODE] [varchar](30) NULL,
	[POL_PHYS_EVID_DESC] [nvarchar](4000) NULL,
	[POL_ADDITM] [nvarchar](4000) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_POL_DTL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_POL_DTL](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[CTRY_CODE_3] [varchar](30) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[BIRTHYEARMMDD] [datetime] NULL,
	[TPHONE] [varchar](20) NULL,
	[HP] [varchar](20) NULL,
	[PASS_NUM] [nvarchar](120) NULL,
	[DOMPERS_FCITY] [nvarchar](100) NULL,
	[DOMPERS_DISTRICT] [nvarchar](100) NULL,
	[DOMPERS_DIST] [nvarchar](100) NULL,
	[DOMPERS_HS_NUM] [nvarchar](100) NULL,
	[DOMPERS_APT_DISTRICT] [nvarchar](30) NULL,
	[DOMPERS_APT_KVARTIR] [nvarchar](30) NULL,
	[FORGNR_FCITY] [nvarchar](100) NULL,
	[FORGNR_DIST] [nvarchar](100) NULL,
	[FORGNR_HS_NUM] [nvarchar](100) NULL,
	[FORGNR_KVARTIR] [nvarchar](30) NULL,
	[SEX_CODE] [varchar](30) NULL,
	[FAM_REL_CODE] [varchar](30) NULL,
	[CRIM_REC] [nvarchar](150) NULL,
	[WRK_PLACE_NM] [nvarchar](200) NULL,
	[INJURY_KND_CODE] [varchar](30) NULL,
	[INJURY_GRD_CODE] [varchar](30) NULL,
	[NARCOTIC_KND_CODE] [varchar](30) NULL,
	[NARCOTIC_WEIGHT] [float] NULL,
	[NARCOTIC_WEIGHT_UNIT_CODE] [varchar](30) NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[HANDWR_STT] [char](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_POL_DTL_TMP]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_POL_DTL_TMP](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[CTRY_CODE_3] [varchar](30) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[BIRTHYEARMMDD] [datetime] NULL,
	[TPHONE] [varchar](20) NULL,
	[HP] [varchar](20) NULL,
	[PASS_NUM] [nvarchar](120) NULL,
	[DOMPERS_FCITY] [nvarchar](100) NULL,
	[DOMPERS_DISTRICT] [nvarchar](100) NULL,
	[DOMPERS_DIST] [nvarchar](100) NULL,
	[DOMPERS_HS_NUM] [nvarchar](100) NULL,
	[DOMPERS_APT_DISTRICT] [nvarchar](30) NULL,
	[DOMPERS_APT_KVARTIR] [nvarchar](30) NULL,
	[FORGNR_FCITY] [nvarchar](100) NULL,
	[FORGNR_DIST] [nvarchar](100) NULL,
	[FORGNR_HS_NUM] [nvarchar](100) NULL,
	[FORGNR_KVARTIR] [nvarchar](30) NULL,
	[SEX_CODE] [varchar](30) NULL,
	[FAM_REL_CODE] [varchar](30) NULL,
	[CRIM_REC] [nvarchar](150) NULL,
	[WRK_PLACE_NM] [nvarchar](200) NULL,
	[INJURY_KND_CODE] [varchar](30) NULL,
	[INJURY_GRD_CODE] [varchar](30) NULL,
	[NARCOTIC_KND_CODE] [varchar](30) NULL,
	[NARCOTIC_WEIGHT] [float] NULL,
	[NARCOTIC_WEIGHT_UNIT_CODE] [varchar](30) NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[HANDWR_STT] [char](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_TRFC_POL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_TRFC_POL](
	[RECPT_NUM] [int] NOT NULL,
	[TRFC_POL_INCID_KND_CODE] [varchar](30) NULL,
	[TRFC_POL_OCR_TM] [datetime] NULL,
	[TRFC_POL_RESID_RGN_DIV_CODE] [varchar](30) NULL,
	[TRFC_POL_RESID_RGN_CITY] [nvarchar](100) NULL,
	[TRFC_POL_RESID_RGN_RGN] [nvarchar](100) NULL,
	[TRFC_POL_RESID_RGN_NM] [nvarchar](100) NULL,
	[TRFC_POL_ROAD_RGN_OWN_CODE] [varchar](30) NULL,
	[TRFC_POL_ROAD_RGN_ROAD_DIV_CODE] [varchar](30) NULL,
	[TRFC_POL_ROAD_RGN_LIMITSPEED] [int] NULL,
	[TRFC_POL_PAVE_YN_CODE] [varchar](30) NULL,
	[TRFC_POL_ROAD_STT_CODE] [varchar](30) NULL,
	[TRFC_POL_LIGHT_CODE] [varchar](30) NULL,
	[TRFC_POL_ACCDNT_OCR_LCT_CODE] [varchar](30) NULL,
	[TRFC_POL_PEDESTRN_VIOLTN_YN_CODE] [varchar](30) NULL,
	[TRFC_ACCDNT_EXP] [nvarchar](4000) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_TRFC_POL_DTL]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_TRFC_POL_DTL](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[CTRY_CODE_3] [varchar](30) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[BIRTHYEARMMDD] [datetime] NULL,
	[TPHONE] [varchar](20) NULL,
	[HP] [varchar](20) NULL,
	[PASS_NUM] [nvarchar](120) NULL,
	[DOMPERS_FCITY] [nvarchar](100) NULL,
	[DOMPERS_DISTRICT] [nvarchar](100) NULL,
	[DOMPERS_DIST] [nvarchar](100) NULL,
	[DOMPERS_HS_NUM] [nvarchar](100) NULL,
	[DOMPERS_APT_DISTRICT] [nvarchar](30) NULL,
	[DOMPERS_APT_KVARTIR] [nvarchar](30) NULL,
	[FORGNR_FCITY] [nvarchar](100) NULL,
	[FORGNR_DIST] [nvarchar](100) NULL,
	[FORGNR_HS_NUM] [nvarchar](100) NULL,
	[FORGNR_KVARTIR] [nvarchar](30) NULL,
	[SEX_CODE] [varchar](30) NULL,
	[FAM_REL_CODE] [varchar](30) NULL,
	[CRIM_REC] [nvarchar](150) NULL,
	[WRK_PLACE_NM] [nvarchar](200) NULL,
	[EXPERNCE] [int] NULL,
	[DRIVE_TM] [int] NULL,
	[DOAM_MEMBER_YN_FLAG] [varchar](30) NULL,
	[TRFC_LAW_VIOLTN_CODE] [varchar](30) NULL,
	[TRUCK_CON_PART_CODE] [varchar](30) NULL,
	[VEHICLE_STT_CODE] [varchar](30) NULL,
	[DRIVE_LICENSE_NUM] [nvarchar](120) NULL,
	[MANUF_MDL] [nvarchar](100) NULL,
	[VEHICLE_NUM] [nvarchar](100) NULL,
	[PERSNDISTRICTCAR_REG_NUM] [nvarchar](120) NULL,
	[WRK_PLACE_ADDR] [nvarchar](4000) NULL,
	[OWNER_ADDR] [nvarchar](4000) NULL,
	[INDIV_OWN] [nvarchar](50) NULL,
	[INJURY_KND_CODE] [varchar](30) NULL,
	[INJURY_GRD_CODE] [varchar](30) NULL,
	[SAFE_APPARAT] [nvarchar](100) NULL,
	[EVAC_PLACE] [nvarchar](200) NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[TRFC_ACCDNT_LEAD_COND_CODE] [varchar](30) NULL,
	[HANDWR_STT] [char](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_TRFC_POL_DTL_TMP]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_TRFC_POL_DTL_TMP](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_DIV_CODE] [varchar](30) NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[CTRY_CODE_3] [varchar](30) NULL,
	[FAM_NM] [nvarchar](100) NULL,
	[GIV_NM] [nvarchar](100) NULL,
	[MID_NM] [nvarchar](200) NULL,
	[BIRTHYEARMMDD] [datetime] NULL,
	[TPHONE] [varchar](20) NULL,
	[HP] [varchar](20) NULL,
	[PASS_NUM] [nvarchar](120) NULL,
	[DOMPERS_FCITY] [nvarchar](100) NULL,
	[DOMPERS_DISTRICT] [nvarchar](100) NULL,
	[DOMPERS_DIST] [nvarchar](100) NULL,
	[DOMPERS_HS_NUM] [nvarchar](100) NULL,
	[DOMPERS_APT_DISTRICT] [nvarchar](30) NULL,
	[DOMPERS_APT_KVARTIR] [nvarchar](30) NULL,
	[FORGNR_FCITY] [nvarchar](100) NULL,
	[FORGNR_DIST] [nvarchar](100) NULL,
	[FORGNR_HS_NUM] [nvarchar](100) NULL,
	[FORGNR_KVARTIR] [nvarchar](30) NULL,
	[SEX_CODE] [varchar](30) NULL,
	[FAM_REL_CODE] [varchar](30) NULL,
	[CRIM_REC] [nvarchar](150) NULL,
	[WRK_PLACE_NM] [nvarchar](200) NULL,
	[EXPERNCE] [int] NULL,
	[DRIVE_TM] [int] NULL,
	[DOAM_MEMBER_YN_FLAG] [varchar](30) NULL,
	[TRFC_LAW_VIOLTN_CODE] [varchar](30) NULL,
	[TRUCK_CON_PART_CODE] [varchar](30) NULL,
	[VEHICLE_STT_CODE] [varchar](30) NULL,
	[DRIVE_LICENSE_NUM] [nvarchar](120) NULL,
	[MANUF_MDL] [nvarchar](100) NULL,
	[VEHICLE_NUM] [nvarchar](100) NULL,
	[PERSNDISTRICTCAR_REG_NUM] [nvarchar](120) NULL,
	[WRK_PLACE_ADDR] [nvarchar](4000) NULL,
	[OWNER_ADDR] [nvarchar](4000) NULL,
	[INDIV_OWN] [nvarchar](50) NULL,
	[INJURY_KND_CODE] [varchar](30) NULL,
	[INJURY_GRD_CODE] [varchar](30) NULL,
	[SAFE_APPARAT] [nvarchar](100) NULL,
	[EVAC_PLACE] [nvarchar](200) NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[TRFC_ACCDNT_LEAD_COND_CODE] [varchar](30) NULL,
	[HANDWR_STT] [char](1) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_INCID_CARD_VIDEO_FILE_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_INCID_CARD_VIDEO_FILE_INFO](
	[RECPT_NUM] [int] NOT NULL,
	[DTL_SEQ_NUM] [int] NOT NULL,
	[VIDEO_FILE_FOLD] [nvarchar](1000) NULL,
	[VIDEO_FILE_NM] [nvarchar](200) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_RECPT_VREC_FILE_INFO]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_RECPT_VREC_FILE_INFO](
	[RECPT_VREC_ID] [varchar](100) NOT NULL,
	[RECPT_NUM] [int] NOT NULL,
	[RECPT_VREC_FILE_FOLD] [nvarchar](1000) NULL,
	[RECPT_VREC_FILE_NM] [nvarchar](200) NULL,
	[CALL_RECVPERSN_ID] [varchar](30) NULL,
	[CALL_ID] [varchar](20) NULL,
	[WORKST_ID] [varchar](20) NULL,
	[CONN_ID] [varchar](20) NULL,
	[CONN_TM] [datetime] NULL,
	[DNIS] [varchar](20) NULL,
	[THIS_DN] [varchar](20) NULL,
	[OTHR_DN] [varchar](20) NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[S_WRONG_REPRT_PHON]    Script Date: 12/11/2021 1:15:14 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[S_WRONG_REPRT_PHON](
	[RECPT_NUM] [int] NOT NULL,
	[CALLER_RGNNUM] [varchar](10) NULL,
	[CALLER_PHONNUM] [varchar](20) NULL,
	[RECPT_REPRT_TM] [datetime] NULL,
	[WIRENLESS_DIV] [varchar](1) NULL,
	[RECPTPERSN_ID] [varchar](30) NULL,
	[PRCS_STT] [varchar](2) NULL,
	[CALLER_FLNAME] [nvarchar](200) NULL,
	[CALLER_PASS_NUM] [nvarchar](300) NULL,
	[CALLER_FCITY] [nvarchar](200) NULL,
	[CALLER_DISTRICT] [nvarchar](100) NULL,
	[CALLER_DIST] [nvarchar](60) NULL,
	[CALLER_HS_NUM] [nvarchar](50) NULL,
	[CALLER_APT_DISTRICT] [nvarchar](20) NULL,
	[CALLER_APT_KVARTIR] [nvarchar](20) NULL,
	[CALLER_ALL_ADDR] [nvarchar](300) NULL,
	[CALLER_LGT] [float] NULL,
	[CALLER_LTT] [float] NULL,
	[REPRTPERSN_FAM_NM] [nvarchar](100) NULL,
	[REPRTPERSN_GIV_NM] [nvarchar](100) NULL,
	[REPRTPERSN_MID_NM] [nvarchar](200) NULL,
	[REPRTPERSN_BIRTHYEARMMDD] [datetime] NULL,
	[REPRTPERSN_TPHONE] [varchar](20) NULL,
	[REPRTPERSN_HP] [varchar](20) NULL,
	[REPRTPERSN_PASS_NUM] [nvarchar](120) NULL,
	[INCIDOCR_FCITY] [nvarchar](100) NULL,
	[INCIDOCR_DISTRICT] [nvarchar](100) NULL,
	[INCIDOCR_DIST] [nvarchar](100) NULL,
	[INCIDOCR_HS_NUM] [nvarchar](100) NULL,
	[INCIDOCR_APT_DISTRICT] [nvarchar](30) NULL,
	[INCIDOCR_APT_KVARTIR] [nvarchar](30) NULL,
	[INCIDOCR_BLDG] [nvarchar](200) NULL,
	[INCIDTYPE_BIGCLSSFY_CODE] [varchar](30) NULL,
	[INCIDTYPE_MEDCLSSFY_CODE] [varchar](30) NULL,
	[INCIDTYPE_SMALLCLSSFY_CODE] [varchar](30) NULL,
	[RELATDBUSN_FIRE_FLAG] [varchar](1) NULL,
	[INCID_OVIEW] [nvarchar](4000) NULL,
	[RELATDBUSN_POL_FLAG] [varchar](1) NULL,
	[RELATDBUSN_TRFC_POL_FLAG] [varchar](1) NULL,
	[REPRTPERSN_HANDWR_STT] [varchar](1) NULL,
	[JURIS_CODE] [varchar](20) NULL,
	[RECPT_CLOSE_TM] [datetime] NULL,
	[INCIDOCR_TM] [datetime] NULL,
	[FST_REGPERSN_ID] [varchar](30) NULL,
	[FINAL_UPTPERSN_ID] [varchar](30) NULL,
	[FST_REG_TM] [datetime] NULL,
	[FINAL_UPT_TM] [datetime] NULL,
	[INCIDOCR_LGT] [float] NULL,
	[INCIDOCR_LTT] [float] NULL,
	[REPRTPERSN_FCITY] [nvarchar](100) NULL,
	[REPRTPERSN_DISTRICT] [nvarchar](100) NULL,
	[REPRTPERSN_DIST] [nvarchar](100) NULL,
	[REPRTPERSN_HS_NUM] [nvarchar](100) NULL,
	[REPRTPERSN_APT_DISTRICT] [nvarchar](30) NULL,
	[REPRTPERSN_APT_KVARTIR] [nvarchar](30) NULL,
	[REPRTPERSN_FORGNR_FCITY] [nvarchar](100) NULL,
	[REPRTPERSN_FORGNR_DIST] [nvarchar](100) NULL,
	[REPRTPERSN_FORGNR_HS_NUM] [nvarchar](100) NULL,
	[REPRTPERSN_FORGNR_KVARTIR] [nvarchar](30) NULL,
	[JURIS_MNG_CODE] [varchar](20) NULL,
	[REPRTPERSN_NAT] [varchar](30) NULL
) ON [PRIMARY]
GO
