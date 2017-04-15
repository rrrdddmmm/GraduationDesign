USE [simulation_laboratory]
GO

/****** Object:  Table [dbo].[project]    Script Date: 2017-04-15 0:50:17 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[project](
	[project_no] [int] NOT NULL,
	[project_name] [varchar](max) NOT NULL,
	[home_no] [int] NOT NULL,
	[user_name] [varchar](max) NOT NULL,
	[project_data] [varchar](max) NOT NULL,
	[project_language] [varchar](max) NOT NULL,
	[develop_platform] [varchar](50) NOT NULL,
	[pronser_number] [int] NOT NULL,
	[crt_time] [date] NOT NULL,
	[update_time] [date] NULL,
	[status] [varchar](10) NOT NULL,
 CONSTRAINT [PK_project] PRIMARY KEY CLUSTERED 
(
	[project_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'project_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'project_name'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'房间名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'home_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'项目成员' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'user_name'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'提交数据' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'project_data'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'所用语言' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'project_language'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'开发平台' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'project', @level2type=N'COLUMN',@level2name=N'develop_platform'
GO


