#coding=utf-8
"""冒泡算法"""
def bubbleSort(numbers):
    for j in xrange(len(numbers) -1, -1, -1):
        for i in xrange(j):
            if numbers[i] > numbers[i+1]:
                numbers[i], numbers[i+1] = numbers[i+1], numbers[i]
        print numbers


def main():
    numbers = [23, 12, 9, 15, 6]
    bubbleSort(numbers)
    pass

if __name__ == '__main__':
    main()