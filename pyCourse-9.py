#%%
a={"이름":"홍길동", "국어":100, "영어":88, "수학": 95}
a["수학"]
a["이름"]
a.keys()
type(a.keys())
a.values()
type(a.values())
a.items()
type(a.items())
#%%
for item in a.items():
	print (item,end=",")
	
#%%
for key in a.keys():
	print (key,end=",")
	
#%%
for value in a.values():
	print (value,end=",")
# %%
print(a.get("과학"))
# 키가 과학인 밸류를 찾되, 없을 경우 "없는 과목입니다" 리턴
print(a.get("과학","없는과목입니다"))  
print(a.get("수학","없는과목입니다"))

#%%
text="""안녕하셔요. 오늘은 날씨가 매우 화창합니다.
그래서 기분이 매우 좋네요
너도 기분이 좋은가요 랄라랄랄라라라라라라 abc임마"""

a=dict()   #빈 딕셔너리 자료형 선언
for c in text:   #text의 한 글자 c에 대해서
    if c not in a:  #해당 추출글자가 지금까지의 딕셔너리에 없다면
        a[c]=1      #그때는 최초 1값으로 시작    
    else:           #이미 저장한 글자일 경우    
        a[c] +=1    #해당 딕셔너리 키에 해당되는 값을 하나더함
print(a)
#%%
b=dict()          #딕셔너리 하나 더 선언
l=list(a.keys())  #기존 딕서너리 키 리스트를 생성
l.sort()          #해당 리스트 소트
for c in l:       #소트한 키값 리스트 기준 앞선 문자부터
    #새 딕셔너리에 해당 문자를 키로, 기존 밸류를 대입해 딕셔너리 채움
    b[c]=a[c]     
print(b)
# %%
a={1,2,2,2,2,3,3,3,4,5}
a
set(("a",1,2))
set("a")
set({"이름":"홍길동", "국어":100, "영어":88, "수학": 95})
set({a,1,2})
set((tuple(a),1,2))
#%%
a={1,2,3,4,5}
a
a.add(0)
a
a.add(2.4)
a
a.remove(3)
a

#%%
A={1,2,3,4,5,6,7}
B={7,8,9,10}
A|B
A&B
A-B
A^B

#%%
{1,2,3} < {1,2}
{1,2,3} > {1,2}
{1,2,3} >= {1,2}
{1,2,3} == {1,2}
{1,2,3} >= {3,1,2}
{1,2,3} == {3,1,2}
#%%
a=["a","b","c","d","e"]
b={}
for i in range (len(a)):
	b[i]=a[i]   #a는 리스트 b는 딕셔너리
	#b[0]=a[0]='a' ... {0: 'a' ... }
b
# %%
a=["a","b","c","d","e"]
b=enumerate(a)  #여기 까지는 중간단계
b 
b=dict(enumerate(a)); c=list(enumerate(a)) #딕셔너리와 리스트를 만든다
b
c
#%%
a={1,2,3,4,5,6,7,8}  #집합a
b={"a","b","c","d","e"} #집합b
zip(a,b) #zip만으로는 단순히 object임
#1-a, 2-b, ... 5-e (단 매칭 및 순서 무작위)
c=dict(zip(a,b)); d=list(zip(a,b))
c
d
a=(1,2,3,4,5,6,7,8) #튜플a
b=["a","b","c","d","e"] #리스트 b
c=dict(zip(a,b)); d=list(zip(a,b))
#1-a, 2-b, ... 5-e (단 매칭 및 순서있음)
c
d

#%%
def func(x):
    if x%2==0:
        return True
    else: 
        return false

x=(1,2,3,4,5,6)
for i in filter(func,x):  
    print(i) 