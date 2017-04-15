USE [simulation_laboratory]
GO

/****** Object:  Table [dbo].[resource]    Script Date: 2017-03-18 16:54:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[resource](
	[resource_name] [varchar](50) NOT NULL,
	[resource_type] [varchar](max) NOT NULL,
	[resource_format] [varchar](max) NOT NULL,
	[upload_date] [date] NOT NULL,
	[username] [varchar](max) NOT NULL,
	[score] [int] NOT NULL,
 CONSTRAINT [PK_resource] PRIMARY KEY CLUSTERED 
(
	[resource_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资源名称' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'resource', @level2type=N'COLUMN',@level2name=N'resource_name'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资源类别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'resource', @level2type=N'COLUMN',@level2name=N'resource_type'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'资源格式' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'resource', @level2type=N'COLUMN',@level2name=N'resource_format'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'上传日期' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'resource', @level2type=N'COLUMN',@level2name=N'upload_date'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'上传者' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'resource', @level2type=N'COLUMN',@level2name=N'username'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'价值' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'resource', @level2type=N'COLUMN',@level2name=N'score'
GO


