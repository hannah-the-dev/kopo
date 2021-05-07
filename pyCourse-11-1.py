import math
math.sin(0)
math.pi
math.sin(math.pi/2.0)
from math import sin  #math 라이브러리에서 sin 임포트
sin(3.141592/2)

import math as m  #math 라이브러리를 m이라는 이름으로 임포트
m.sin(m.pi/2.0)

import math
help(math)
#%%
from math import sin,pi  #math 라이브러리에서 sin, pi 임포트
for i in range(360):    #0부터 359까지 자연수 i마다
    sin_value=sin(i*pi/180) #i에 라디안값을 곱한 값의 sin을 구함
    space_value=int( (1+sin_value)*50)  #양수화하기 위해 평행이동한 sin 값을 50배(버림)
    print(" "*space_value, end="")   #50배한 값만큼 white space 출력, 줄바꿈없음
    print("[%f]"%sin_value)      #공백에 이어서 sin값 출력

#%%
from math import sin,pi   #math에서 sin, pi 임포트
import matplotlib.pyplot as plt  #설치한 외부 라이브러리 임포트

graph_value=[]  #리스트 선언,빈 리스트를 만들어야 append가능 
for i in range(360):
    graph_value.append(sin(i*pi/180)) #sin값을 하나씩 리스트에 넣음

plt.plot(graph_value) #해당 리스트를 그래프 함수에 보냄
plt.show()

# %%
import  statistics as s
a=[100,95,25,33,45,90,100,35,25]
s.mean(a) #평균
s.stdev(a) #표준편차
s.variance(a) #분산
#%%
import statistics as s
s.harmonic_mean([120,80])

#%%
import time as t
a = t.time(); a   #현재시간
t.ctime(a)  #초단위로 표시된 시간을 문자형식으로 표현
t.ctime(0) #우리나라 기준으로 time=0의 경우 1970년1월1일 오전9시 정각

a=t.localtime()
a
#tm_year: 년도; tm_mon: 월; tm_mday: 일; tm_hour: 시;
#tm_min: 분; tm_sec: 초; tm_wday: 요일(0월요일,1화요일~7일요일);
#tm_yday: 1/1부터 경과일; tm_isdst: 일광절약일(썸머타임 적용시, 적용x:0)
print("%d년 %d월 %d일 %02d시 %02d분 %02d초"%(a.tm_year,a.tm_mon,a.tm_mday,a.tm_hour,a.tm_min,a.tm_sec))

#%%
import datetime as t
a=t.datetime.now()
print("%d년 %d월 %d일 %02d시 %02d분 %02d초"%(a.year,a.month,a.day,a.hour,a.minute,a.second))

#%%
import time as t

start=t.time()
for i in range(10000):
    pass
end=t.time()

print("%f 초 동안 실행함"%(end-start))

#%%
for i in range(10):
    print (t.ctime())
    t.sleep(3)  #초단위

#%%
import random as r
import matplotlib.pyplot as plt

score=[]
for i in range(100):  #100번 반복
    score.append(r.randrange(0,100)) # 0부터 100까지 랜덤수 발생

plt.plot(score)
plt.show()

# %%
import sys
sys.version  #파이썬 버전 조회
				    
sys.platform #파이썬 설치 플랫폼
				    
sys.getwindowsversion() #설치된 윈도우의 버전

#%%
import os
os.getcwd()
os.system("calc") #계산기 실행
os.system("IDLE") #IDLE실행,실행안됨 path가 다름, 1리턴
os.system("python") #파이썬 실행 실행된 상태에서 기다림
os.system("shutdown /f /t 100") #이 명령 수행전 모든 윈도우 프로그램을 정리할 것

os.system("shutdown /a")

#%%
from urllib.request import urlopen

with urlopen('http://www.kopo.ac.kr/') as response:
    for line in response:
        line = line.decode('utf-8')  # 한글 처리
        if "폴리텍" in line:
            print(line)
