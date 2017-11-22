#coding=utf-8
import random
def compareNum(num1,num2):
    if(num1 > num2):
        return 1
    elif(num1 == num2):
        return 0
    else:
        return -1
num1 = random.randrange(1,9,3)
# 取随机数1:范围的起始值,9:范围的末尾值不包括,3：步长)
# 可能取值为[1,4,7]
num2 = random.randrange(1,9,2)


class Student:    #类名使用大写
    __name = ""   #私有实例变量前必须有两个下划线
    def __init__(self,name):  #self相当于java中的this
        self.__name = name
    def getName(self):  #方法名命名规则
        return self.__name


if __name__ == '__main__':
    student = Student("速度是结婚的空间！！！")  #对象名小写
    print student.getName()
    print "num1 = ", num1
    print "num2 = ", num2
    print compareNum(num1,num2)