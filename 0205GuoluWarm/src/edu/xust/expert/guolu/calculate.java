package edu.xust.expert.guolu;
/*选择隶属函数*/

public class calculate {
	double A;
	double LiShuZhi(double avg, int c, double a, double b) {
		switch (c) {
			case 1://上半梯形
			{
				if (avg <= b)
					A = 0;
				else if (avg >= a)
					A = 1;
				else
					A = (avg - a) / (b - a);
			}break;
			case 2:// 下半梯形
			{
				if (avg <= b)
					A = 1;
				else if (avg >= a)
					A = 0;
				else
					A = (b - avg) / (b - a);
			}break;
			case 3:// 上半矩形
			{
				if (avg > a)
					A = 1;
				else
					A = 0;
			}break;
			case 4:// 下半矩形
			{
				if (avg > a)
					A = 0;
				else
					A = 1;
			}break;
		}
		return A;
	}
}
