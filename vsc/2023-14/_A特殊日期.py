mon = [0,31,28,31,30,31,30,31,31,30,31,30,31]
def run(x):  #判断是否为闰年
    if x%400==0 or (x%4==0 and x%100!=0):
        return True
    return False
res = 0
for year in range(2000,2000000):
    if run(year):
        mon[2]=29
    else:
        mon[2]=28
    for mm in range(1,13):
        if year%mm != 0:
            continue
        for dd in range(1,mon[mm]+1):
            if year%dd==0:
                res += 1
print(res+1)  #前面只迭代到了1999999年12月31日，最后2000000年1月1日也是一个答案