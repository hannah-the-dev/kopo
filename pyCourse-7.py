#%%
print("별10개 찍기")
for i in range(10):
    print("*",end="")
print("\n")

print("별3개 찍기")
for i in range(3):
    print("*",end="")
print("\n")

print("별5개 찍기")
for i in range(5):
    print("*",end="")
print("\n")    
# %%
def starprint(n):   # 함수 정의
    for i in range(n):  # n번 반복
        print("*",end="")  #줄바꿈없이 별찍기
    print("\n")  # 끝난 후 줄바꿈


print("별10개 찍기"); starprint(10)
print("별3개 찍기"); starprint(3)
print("별5개 찍기"); starprint(5)
# %%
def intsum(n): 
    sum=0   
    for i in range(1, n+1, 1): #1부터 n+1까지 1씩 증가하며
        sum+=i  # sum에 i값 더하기
    return sum
print("1~10까지의 합:",intsum(10))
print("1~1000까지의 합:",intsum(1000))
print("1~10000까지의 합:",intsum(10000))
# %%
def intsum1(x,y):
    sum=0
    for i in range(x, y+1, 1): # x부터 y까지 1씩 증가하면서
        sum+=i   # sum 변수에 더하기
    return sum

print("1~10까지의 합:", intsum1(1,10))
print("100~1000까지의 합:", intsum1(100,1000))
print("5000~10000까지의 합:", intsum1(5000,10000))
# %%
def intsum2(x,y):
    sum=0
    for i in range(x,y+1,1):
        sum+=i
    return sum

print("1~10까지의 합에 5를 더함:", intsum2(1,10)+5)
i=intsum2(100,1000)*33
print("100~1000까지의 합에 33을 곱함:", i)
# %%
def intsum3(x,y):
    sum=0
    for i in range(x,y+1,1):
        sum+=i
    print("함수내부에서 sum값을 출력:",sum)  #return 없음

# i=intsum3(100,1000)
# print("100~1000까지의 합:",i)
# print("100~1000까지의 합에 33을 곱함:",i*33)
# %%  트와이스 성적표
def titleprint():
   print("="*50)
   print("이름\t국어\t영어\t수학\t총점\t평균")
   print("="*50)

def itemprint(name,kor,eng,mat):
   print(name,"\t",kor,"\t",eng,"\t",mat,"\t",kor+eng+mat,"\t",(kor+eng+mat)//3)

def tailprint():
   totkor=0
   for i in ckor:  # 각학생의 국어 점수를 한개씩 돌아가면서
       totkor+=i   # 전체 국어점수 합계에 더함
   toteng=0
   for i in ceng:
       toteng+=i
   totmat=0
   for i in cmat:
       totmat+=i
   print("="*50)  # '=' 50개 찍기
   print("반총점\t",totkor,"\t",toteng,"\t",totmat,"\t"\
         ,(totkor+toteng+totmat)//9,"\t",(totkor+toteng+totmat)/3//9)
   print("="*50)

#데이터
cname=["나연","정연","모모","사나","지효","미나","다현","채영","쯔위"]
ckor =[ 100,100,90,90,100,80,70,80,100]
ceng =[ 90,100,100,80,100,70,60,100,100]
cmat =[ 100,80,100,90,100,90,100,90,100]

#여기부터 프로그램
titleprint()
for i in range(9):
    itemprint(cname[i],ckor[i],ceng[i],cmat[i])
tailprint() 
# %%
def sumsum(*num):
   sum=0
   for i in num:  #가변인수 num이 리스트로 들어온다고 이해
       sum+=i
   return sum

print("case 1:", sumsum(1))
print("case 2:", sumsum(1,2,4))
print("case 3:", sumsum(1,2,34,567,8901))
# %%
def sumsum1(num):  #단일 인수를 리스트로 받는 함수
   sum=0
   for i in num:
       sum+=i
   return sum

print("case 1:", sumsum1([1]))  #인수가 하나라도 리스트 타입으로 전달
print("case 2:", sumsum1([1,2,4]))
print("case 3:", sumsum1([1,2,34,567,8901]))
# %%
def defaultest (start,end=1000,step=1):
   sum=0
   for i in range(start,end+1,step):
       sum+=i
   return sum

print("case 1:", defaultest(0,10,1))
#인수 하나를 생략시 맨뒤 step값이 1로 기본값처리
print("case 2:", defaultest(50,100)) 
#인수 둘 생략시 맨뒤 step값이 1,
#end 값이 1000으로 기본값처리
print("case 3:", defaultest(100)) 
# %%
print("case 1:", defaultest(0, 10, 1))
print("case 2:", defaultest(start=0, end=10, step=1))
#키워드 지정시 순서가 상관없음
print("case 3:", defaultest(step=1, end=10, start=0))
#맨뒤로 부터만 키워드 인수를 사용하고 앞은 일반인수
print("case 4:", defaultest(0, 10, step=1))
#맨뒤로 부터만 키워드 인수를 사용하고 앞은 일반인수
print("case 5:", defaultest(0, step=1, end=10))
# %%
# print("error1:", defaultest(0,step=1,10))
# print("error2:", defaultest(start=0,step=1,10))
# %%
def testfunc (**args):
   start=args["start"]  # 키워드 가변
   end=args["end"]      # 키워드 가변
   step=args["step"]    # 키워드 가변
   sum=0
   for i in range(start,end+1,step):
       sum+=i
   return sum

print("case 1:", testfunc(start=0,end=10,step=1))
print("case 2:", testfunc(end=100,step=1,start=10))
# %%
print("case 3:", testfunc(end=100,step=1,start=10, a=30))
# print("case 4:", testfunc(end=100,step=1, a=30))
print("case 5:", testfunc(end=100,step=1))

# %%
def testfunc1 (*s,**args):
   start=args["start"]
   end=args["end"]    
   step=args["step"]  
   for c in s:  # 가변인수를 하나씩 돌아가면서
       print(" "*start,end="")  #start 만큼 공백 출력
       for i in range(start,end+1,step): # 가변인수를 (end-start)/step만큼출력
           print(c,end="") 
       print("\n")

print("="*30)
testfunc1("*","&","=",start=0,end=10,step=1)
print("="*30)
testfunc1("*","?","=","%",start=3,end=10,step=1)
# %%
def test():
    a=1

test()
print(a) # 에러발생
# %%
def testf1():
    a=1
    print("testf1:",a)

def testf2():
    a="즐거운 실습"
    print("testf2:",a)

def testf3():
    a=3.141592
    print("testf3:",a)

testf1()
testf2()
testf3()
a="랄랄라"
print(a)  # 전역변수 랄랄라
# %%
def testf1():
    print("testf1: 현재 달러환율은 1달러당 ",exrate,"원이며")
    print("testf1: 미화 100달러는 ",100*exrate,"원 입니다")

def testf2():
    exrate=1011
    print("testf2: 현재 달러환율은 1달러당 ",exrate,"원이며")
    print("testf2: 미화 100달러는 ",100*exrate,"원 입니다")

exrate=1021
testf1()  # 전역변수 사용됨 1021
exrate=1120 # 전역변수 변경
testf1()  # 전역변수 사용됨 1120

testf2() #case 1   # 함수 내 선언된 지역변수 사용됨  1011
testf1() #case 2   # 전역변수 사용됨 1120

# %%
def testf1():
    """
    이 함수는 홍필두가 최선을 다하여 멋지게 만든 함수
    인수 값에 숫자만큼 1부터 해당 값을 더한 값을 출력해 준다
    """
    sum = 0
    for i in range(n + 1):
        sum += i
    print("합:", sum)

# 프로그램에서(특히 대화식 모드) 해당함수가 궁금할 때
help(testf1)
# %%
