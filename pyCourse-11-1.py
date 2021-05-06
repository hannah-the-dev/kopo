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
