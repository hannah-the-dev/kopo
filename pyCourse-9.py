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

#%%
a="abcde"
a[0],a[1],a[2],a[3],a[4]      # 앞에서부터
a[-1],a[2],a[-3],a[-4],a[-5]  # 뒤에서부터
a="가나다라마"
a[0],a[1],a[2],a[3],a[4]    # 앞에서부터

#%%
a="abcde"
a[1:5]
a[1:2]
a[:6]
a[3:]
a[2:-2]
a[2:-3]
a[1:-1]
a[:7]
type(a)
type(a[:1])
b='a'
type(b)
c=chr(65)
type(c)

#%%
a="abcdefghijklmabcdefgh"
a.find("f") #앞에서 부터 f 찾기, 찾은 첫 f의 인덱스
a.rfind("f") #뒤에서 부터 f 찾기, 찾은 첫 f의 인덱스
a.find("i"), a.rfind("i") #만일 찾는 문자가 하나라면 결과는 동일
a.index("b"), a.rindex("b") #index함수도 결과는 동일
a.find("9")
a.index("9") #index함수는 없을 경우 에러 발생

#%%
a.rindex("z")  #하지만 찾는 문자가 없으면 에러발생
a.count("f") #해당 문자의 개수를 반환
a.rfind("abc") #문자열을 넣어도 됨

#%%
a="abcdfegabcdfeg"
if a.find("a") >= 0:
    print ("a가 들어 있음")
if "f" in a : #만일 "f"가 a안에 있다면..으로 자연적 영어표현
    print ("f가 들어 있음")

#%%
a="abcDefGh"
a.upper()  #모든 캐릭터 upper
a="abcDefGh"
a.lower()  #모든 캐릭터 lower
a
a[0:2].upper() #ab upper

#%%
a="   abc   def  hij       "
a.lstrip()   #왼쪽 공백 지우기
a="   abc   def  hij       "
a.rstrip()   #오른쪽 공백 지우기
a="   abc   def  hij       "
a.strip()    #양쪽 공백 지우기
a="   abc   def  hij       "
a.replace(" ","")  #모든 공백을 없앰
a

#%%
rec="안설란,100,95,88"
        
item=rec.split(",")  #리스트
print("="*15)
print("이름: ", item[0])
print("국어: ", item[1])
print("영어: ", item[2])
print("수학: ", item[3])
print("="*15)

type(item)
# %%
rec="본 예제는 빈칸으로 구분되어 있는 한 줄의 데이터를 빈칸을     구분하여 나누어 줌"
item=rec.split(" ")

print("="*15)
i=0
for s in item:  # 아이템 리스트 1개 원소마다
    print(i,"==>", s)
    i+=1
print("="*15)

#%%
dili_score=["나연,100,90,100",
       "정연,90,90,100",
       "모모,80,70,90",
       "사나,90,90,80",
       "지효,100,80,80",
       "미나,50,90,90",
       "다현,80,60,100",
       "채영,70,80,90",
       "쯔위,100,90,90"]

score = []
for one_rec in dili_score:
    one_score = one_rec.split(",")
    one_score[1] = int(one_score[1])
    one_score[2] = int(one_score[2])
    one_score[3] = int(one_score[3])
    # score.append(one_score.copy())
    score.append(one_score)
    one_score[1] = 100
print(score)

#%%
item="오징어땅콩"   #품목
unit=1000           #단가
qty=10              #수량
tot=unit*qty        #합계

print("case1") #지금까지 사용한 print방법, 칸 띄워 출력
print("품목:",item," 단가:",unit,"원 수량:",qty,"개 합계:",tot,"원")

print("case2") #하나의 긴 문자열을 만들어 출력하면 공백없이 출력이 가능
print("품목:"+item+"  단가:"+str(unit)+"원  수량:"+str(qty)+"개  합계:"+str(tot)+"원")

print("case3") #출력포맷문자를 지정하여 원하는 포맷으로 출력이 가능
print("품목:%s  단가:%d원  수량:%d개  합계:%d원"%(item,unit,qty,tot))

print("case4") #포매팅 예
print("품목:%-10s  단가:%05d원  수량:0x%02x개  합계:%10.3f원"%(item,unit,qty,tot))

#%%
item="땅콩"   #문자
unit=1000     #숫자
#오른쪽정렬/왼쪽정렬/오른쪽정렬하고0으로 채움
print("[%5d][%-5d][%05d]"%(unit,unit,unit)) 
print("[%5s][%-5s][%05s]"%(item,item,item))  #문자열은0으로 채워지지 않음
#10진수 16진수, 16진수(0x**), 8진수
print("[%d]=[%x][%#x][%o]"%(unit,unit,unit,unit))
print("[%5d%%]"%unit) # 오른쪽정렬하고%붙이기

#한글은 1byte로 자르면 에러
print("[%c][%c][%c]"%(unit[0],unit[1],unit[2]))
print("[%c][%c]"%(item[0],item[1]))
a="abcd"
print("[%c][%c][%c]"%(a[0],a[1],a[2]))
#%%
import locale #locale라이브러리를 임포트 함, 설치는 필요없음
locale.setlocale(locale.LC_ALL, "") # 시스템 기본 로케일 사용
#문화권 특정 데이터 포맷의 데이터베이스에 액세스
n = -1234567890.123
s = locale.format_string("%.3f", n, 1)
print(s)

#%%
import locale #locale라이브러리 임포트
locale.setlocale(locale.LC_ALL, "") # 시스템 기본 로케일 사용

won = 1_000_000   #100만원: 바꿀 돈
fxRate = 1010.12 # 달러환율
feeRate = 0.002 # 은행 수수료 율
a = fxRate + fxRate * feeRate  # 1달러당 환율금액 과 해당금액에 대한 수수료의 합
usd = int (won /a)  # 지급 달러: 버림 금액
remain = int(won - usd * a)  # 거스름돈 계산 =100만원 - 달러액*(환율+달러당 수수료): 버림
commission = usd * fxRate *  feeRate # 환전 수수료총액 계산: 올림
if(commission != float(int(commission))) : # 소수자리가 있다면 (기본계산법과 버림한 금액이 다르면)
    commission = int(commission) +1 #수수료 금액에 1을 더해 계산
else:                               #소수자리가 없다면
    commission = int(commission) # 기본계산한 수수료를 정수화해서 마무리
 
print("***************************************************")
print("총금액: %s원 \t달러환율: $%s"%( \
    locale.format_string("%12d", won, 1), \
    locale.format_string("%-12.2f", fxRate, 1)) )

print("지급달러: $%s"% locale.format_string("%-12d", usd, 1))
print("거스름돈: %s원 \t은행수수료: %s원"%( \
    locale.format_string("%6d", remain, 1), \
    locale.format_string("%6d", commission, 1)) )
print("***************************************************")