#%%
a=1122
print(a)
print(type(a))
b="hello";print(b);
print(type(b))
b=12
print(type(b)) 
# %%
text = ''' 안녕하셔요. 오늘은 날씨가 매우 화창합니다.​

그래서 기분이 매우 좋네요​

너도 기분이 좋은가요 랄라랄랄라라라라라라 abc임마 '''


a=dict()   #하나의 딕셔너리 자료형을 정의​
for c in text:   #위에 정의한 텍스트를 하나씩 추출하여 처리​
    if c not in a:  #해당 추출글자가 지금까지의 딕셔너리에 없다면​
        a[c]=1      #그때는 최초 1값으로 시작    ​
    else:           #이 경우는 해당 추출글자의 딕셔너리가 있다    ​
        a[c] +=1    #그럼 해당 딕셔너리 키에 해당되는 값을 하나더함​
a
# %%
A={1,2,3,4,5,6,7}
B={7,8,9,10}
A^B
# %%
A-B
# %%
def func(x):
    print(x/3)
    return x/3

x=(1,2,3,4,5,6)
for list(i) in filter(func,x):
    print(i)

# %%
