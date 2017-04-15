USE [simulation_laboratory]
GO

/****** Object:  Table [dbo].[project_progress]    Script Date: 2017-03-18 16:52:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[project_progress](
	[project_no] [int] NOT NULL,
	[立项书] [varchar](max) NOT NULL,
	[需求分析] [varchar](max) NOT NULL,
	[概要设计] [varchar](max) NOT NULL,
	[详细设计] [varchar](max) NOT NULL,
	[编码] [varchar](max) NOT NULL,
	[测试] [varchar](max) NOT NULL,
 CONSTRAINT [PK_project_progress] PRIMARY KEY CLUSTERED 
(
	[project_no] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


