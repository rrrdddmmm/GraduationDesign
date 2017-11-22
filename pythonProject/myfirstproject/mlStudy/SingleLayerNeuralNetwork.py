# coding: UTF-8
import numpy as np
import matplotlib.pyplot as plt
#输入数据
X = np.array([[1,3,3],[1,4,3],[1,1,1]])
#标签
Y = np.array([1,1,-1])
#权值初始化:random返回随机的浮点数，在半开区间 [0.0, 1.0)。
W = (np.random.random(3)-0.5)*2
print(W)
#学习率的设置#coding=utf-8
nn = 1.5
kk = 0.1
x = -4.0
while (1):
    if abs(x - 2)* nn - 0 <= kk:
        break
    x=x-nn*(x-2)
print x
lr = 0.11
#计算迭代次数
n = 0
#神经网络输出
O = 0
def update():
    global X,Y,W,lr,n
    n+=1
    #输出矩阵
    O = np.sign(np.dot(X,W.T))
    print(O)
    print(O.T)
    print(Y)
    print(Y-O)
    W_C = lr*(Y-O).dot(X)/int(X.shape[0])
    W = W + W_C
for _ in range(100):
    update()
    O = np.sign(np.dot(X,W.T))
    if(O == Y.T).all():
        print("完后")
        print("each:",n)
        break
x1 = [3,4]
y1 = [3,3]
x2 = [1]
y2 = [1]
k = -W[1]/W[2]
d = -W[0]/W[2]
xdata = np.linspace(0,5)
plt.figure()
plt.plot(xdata,xdata*k+d,'r')
plt.plot(x1,y1,'bo')
plt.plot(x2,y2,'yo')
plt.show()
