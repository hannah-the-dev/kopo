#%%
a=[1,2,3,4,5]
a[0],a[1],a[2],a[3],a[4]
# %%
a=[11,"abc",12.3333,"안녕",2+3j]
print(a[0],a[1],a[2],a[3],a[4])
print(a)
print(type(a))
print(type(a[0]),type(a[1]),type(a[2]),type(a[3]),type(a[4]))
#%%
a[1]=1234;a[4]="홍길동"
a
#%%
score=[90,80,70,60,30]
sum=0
for s in score:
    print("점수(",s,")")
    sum+=s
print("총점:",sum)
#%%
a=[1,2,3,4,5]
a[0],a[-5]
a[1],a[-4]
a[2],a[-3]
a[3],a[-2]
a[4],a[-1]
# %%
a=[1,2,3,4,5,6,7,8,9,10]
a[2:8] # 2부터 8보다 작을 때까지(2,3,4,5,6,7)
a[:4] #처음부터 4보다 작을 때까지(0,1,2,3 주의 a[4]제외)
a[5:] #5부터 끝까지
a[0:6:3] #0부터 6보다 작을때 까지(6은 제외 0,3) 3씩 증가하여
# %%
a=[[1,2,3],[4,5,6],[7,8,9]] # 리스트로 구성된 리스트
a[2]
a[2][2]
a[1][3]
a[1][2]
a=[[1,2],[3,4,5],6] # 가변 형태의 리스트
a
a[2]
a[1]
#%%
a=[ n * 3 for n in range (1,10)]
a
#%%
a=[ n * 3 for n in range (1,10) if n % 2 ==0 ]
a
#%%
def titleprint():
   print("="*50)
   print("이름\t국어\t영어\t수학\t총점\t평균")
   print("="*50)

def itemprint(name,kor,eng,mat):
   print(name,"\t",kor,"\t",eng,"\t",mat,"\t",kor+eng+mat,"\t",(kor+eng+mat)//3)

def tailprint():
   totkor = 0
   toteng = 0
   totmat = 0
   for one_student in score:         #학생별 점수리스트 하나마다
       totkor += one_student[kor]    #과목별 총점에 각 점수 더함
       toteng += one_student[eng]
       totmat += one_student[mat]
   print("="*50)
   # 점수별 총점 출력, 점수별 반평균(학생수로 나눔), 총점 및 평균 출력
   print("반총점\t",totkor,"\t",toteng,"\t",totmat,"\t"   
         ,(totkor + toteng + totmat)//len(score),"\t",(totkor+toteng+totmat)/3//len(score))
   print("="*50)

#데이터 2차원 리스트 (row: 학생; column: 이름, 국어, 영어, 수학 점수)
score=[["나연",100,90,100],
       ["정연",90,90,100],
       ["모모",80,70,90],
       ["사나",90,90,80],
       ["지효",100,80,80],
       ["미나",50,90,90],
       ["다현",80,60,100],
       ["채영",70,80,90],
       ["쯔위",100,90,90]]
#프로그램을 보기 좋게 하려고 상수를 정의
name=0; kor=1; eng=2; mat=3
#메인파트
titleprint()
for one_student in score:
    itemprint(one_student[name],one_student[kor],one_student[eng],one_student[mat])
tailprint()
#%%
a=[1,2,3,4,5]
a
del a[2] #2번 리스트요소 삭제
a
[1, 2, 4, 5]
del a[2]
a
a.clear() #리스트 전부 지움
a #빈 리스트는 남아있음
del a #a공간도 지움
a
#%%
a=[]
del a
a.append(1) #del로 공간까지 지원 상태로 추가 불가
a=[] #빈 리스트를 정의
a.append(1) #1값의 리스트요소를 추가(인덱스 아님 주의)
a.append(3)
a.append(5)
a
a=[4,5,6] #기존 a를 무시하고 다시 정의
a.append(10)
a
#%%
a=[1,2,3,4,5]
a.append(6) #append는 맨 뒤에 하나의 요소를 삽입
a
a.insert(3,12)  #3번째 인덱스에 12 끼워넣기
a
a.insert(4,15)
a
a.insert(3,1)
a
a.insert(-3,1)  #뒤에서부터 세번째 인덱스 앞에 1 끼워넣기
a
# %%
a=[1, 2, 3, 1, 12, 15, 4, 5, 6]
a[5:5]=[1,2,3,4,5,6] #5에서 5까지 영역에 해당 리스트 값을 끼워넣기
print(a)
a[5:11]=[0,1,2,3,4,5] #5에서 5까지 영역에 해당 리스트 값을 끼워넣기
print(a)
a[5]=[1,2,3,4,5,6] #5에서 5까지 영역에 해당 리스트 값을 끼워넣기
print(a)
#%%
a=[1,2,3]
b=[4,5,6]
a=a+b
print(a)
a=[1,2,3]
b=[4,5,6]
a.extend(b)
print(a)
# %%
a=[1,2,3,3,4,4,5,6,7,7,7,7,8]
print(a)
a.remove(7) #첫 번째 만나는 7 삭제
print(a)
a.remove(7) #첫 번째 만나는 7 삭제
print(a)
a[5]=[]  #다섯 번째 인덱스를 빈 값[]이중 리스트로 변경 (주의: a[5:5]=[]라고 해야 함)
print(a)
a[2:4]=[]
print(a)
del(a[4]) #네번째 인덱스 삭제
print(a)
del(a[3])
print(a)
a.clear() #리스트 내용 지우기(a=[])
print(a)
del(a) #리스트 공간 삭제
print(a)
# %%
a=[1,2,3,3,4,4,5,6,7,7,7,7,8]
a.pop()   # 마지막 a 꺼내기
a
a.pop()
a.pop(3)
a
a.pop(6)
a
a.pop(6)
a.pop(0)
a
# %%
a=[1,2,3,3,4,4,5,6,7,7,7,7,8]
a.index(7) #값 7의 인덱스 중 가장 작은 것
a.index(8) #값 8의 위치는 12(0부터 시작)
a.index(4) #값 4의 위치는 4(0부터 시작)
a.count(7) #7은 4번 나옴
min(a);max(a);len(a)

a=[1,8,5,6,2,4,5,2,6,9,4]
a.reverse() #값의 크기와 상관없이 현재 순서의 역순
a
a.sort()  #오름차순 정렬
a
a.sort(reverse=True)  #내림차순 정렬
a
#%%
import random as r
def titleprint():
   print("="*50)
   print("이름\t국어\t영어\t수학\t총점\t평균")
   print("="*50)

def itemprint(name,kor,eng,mat):
   print(name,"\t",kor,"\t",eng,"\t",mat,"\t",kor+eng+mat,"\t",(kor+eng+mat)//3)

def tailprint():
   totkor = 0
   toteng = 0
   totmat = 0
   for one_student in score:         #학생별 점수리스트 하나마다
       totkor += one_student[kor]    #과목별 총점에 각 점수 더함
       toteng += one_student[eng]
       totmat += one_student[mat]
   print("="*50)
   # 점수별 총점 출력, 점수별 반평균(학생수로 나눔), 총점 및 평균 출력
   print("반총점\t",totkor,"\t",toteng,"\t",totmat,"\t"   
         ,(totkor + toteng + totmat)//len(score),"\t",(totkor+toteng+totmat)/3//len(score))
   print("="*50)

one_person=[]
score=[]
for i in range(100):  # 100명 실시
    one_person.append("name"+str(i)) #이름 (name1, name2,...)
    one_person.append(r.randrange(10,100)) #국어 10부터 100까지 임의에 값을 추출
    one_person.append(r.randrange(10,100)) #영어
    one_person.append(r.randrange(10,100)) #수학
    score.append(one_person[:]) #값을 복사해서 추가함에 주의할 것
    one_person.clear()

#프로그램을 보기 좋게 하려고 상수를 정의
name=0; kor=1; eng=2; mat=3
#메인파트
titleprint()
for one_student in score:
    itemprint(one_student[name],one_student[kor],one_student[eng],one_student[mat])
tailprint()
# %%
a=(1,8,5,6,2,4,5,2,6,9,4)
a
a[5]
a[3:5]
a[3:8]
a*2
a
a[1]=5  #값 변경불가
del a[4] #변수 지우기 불가
a.append(10)
#%%
def location():
    latitude = 2, 17403  # 위도
    longitude=41,40338  #경도
    return latitude,longitude  #이런방식의 리턴은 튜플로 반환
    # 자바와는 달리 리턴값 여러개 가능

a=location()
print(a)