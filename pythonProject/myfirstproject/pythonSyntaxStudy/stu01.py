#coding=utf-8
#测试print函数利用元组数据类型传递参数
def testprint():
    age = 30
    name = "bill"
    # 字符串转义
    str = 'c:\\now'
    print str 
    # 原始字符串:给字符串前面添加r
    # 原始字符串不能再最后加上‘\’的，“r'c:\dd\ff\gg'”错误
    str = r'c:\dd\ff\gg'
    # 如果非要在原始字符串添加‘\’呢？怎么做？
    str = str + '\\'
    print str


    print "%s is %d years old" %(name,age)

#入口函数书写方式
if __name__ == '__main__':
    print("Hello Word")
    testprint()
