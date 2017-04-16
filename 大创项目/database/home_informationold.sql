USE [simulation_laboratory]
GO

/****** Object:  Table [dbo].[home_information]    Script Date: 2017-03-18 16:49:51 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[home_information](
	[home_no] [int] NOT NULL,
	[project_name] [varchar](max) NOT NULL,
	[peoplenum_max] [int] NOT NULL,
	[application_days] [int] NOT NULL,
	[team_name] [varchar](max) NOT NULL,
	[peoplenum_true] [int] NOT NULL,
 CONSTRAINT [PK_home_information] PRIMARY KEY CLUSTERED 
(
	[home_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'房间名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'home_information', @level2type=N'COLUMN',@level2name=N'home_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'home_information', @level2type=N'COLUMN',@level2name=N'project_name'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'最多人数' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'home_information', @level2type=N'COLUMN',@level2name=N'peoplenum_max'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'申请天数' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'home_information', @level2type=N'COLUMN',@level2name=N'application_days'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'团队名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'home_information', @level2type=N'COLUMN',@level2name=N'team_name'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'实际人数' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'home_information', @level2type=N'COLUMN',@level2name=N'peoplenum_true'
GO


