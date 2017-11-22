#coding=utf-8
nn = 1.5
kk = 0.1
x = -4.0
while (1):
    if abs(x - 2)* nn - 0 <= kk:
        break
    x=x-nn*(x-2)
print x