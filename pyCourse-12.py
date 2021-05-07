f=0
try:
    f=open("LICENSE.txt","rt")
    while True:
        r=f.readline()
        if not r:
                break
        print(r)      
except FileNotFoundError:
    print("파일없음")
finally:
    if(f): f.close()
    print("프로그램 끝")

#%%
import random as r
f=0
f=open("score.txt","wt")  #파일을 텍스트 쓰기 모드로 열기
for i in range(100):   #100번 반복
# 아래와 같은 형태를 만들기 위하여 str.format 함수를 사용할 수 있다.
#   one_person="{0:s},{1:d},{2:d},{3:d}\n“
#.format("홍길동"+str(i),r.randrange(0,100),r.randrange(0,100),r.randrange(0,100))
   #홍길동+번호, 랜덤점수 3개, 개행문자 
    one_person="홍길동"+str(i)+","+str(r.randrange(0,100))+","+str(r.randrange(0,100))+","+str(r.randrange(0,100))+"\n"
    f.write(one_person) #생성한 문자열을 파일로 한줄 작성
    print(one_person)   #생성한 문자열을 콘솔 출력
f.close()   # 파일 닫기

#%%
f=0
f=open("score.txt","rt")
while True:
    one_person=f.readline() #한 줄씩 읽는다
    if not one_person: break #읽을 내용이 없으면 루프탈출
    one_person=one_person.replace("\n","") #줄 바꿈문자 없애기
    item=one_person.split(",") #콤마 구분자로 짜르기
    print("="*10)
    print("이름: ", item[0])
    print("국어: ", item[1])
    print("영어: ", item[2])
    print("수학: ", item[3])
    print("="*10)
f.close()
#%%
import sqlite3 as s
con = s.connect("mydata.db")
cursor = con.cursor()   #커서 객체 연결
cursor.execute("SELECT name FROM sqlite_master WHERE type='table';") #테이블보기
print(cursor.fetchall())   # 테이블 출력
cursor.execute("drop table examtable;")  # 테이블 삭제
con.commit()  #실행내용 데이터베이스 적용

#\: 이어작성
cursor.execute(" \
    create table examtable( \
        name varchar(20), \
        studentid int not null primary key, \
        kor int,\
        eng int, \
        mat int)\
            ;")
con.commit()
cursor.close()
con.close()

# %%

con = s.connect("mydata.db")
cursor = con.cursor()   #커서 객체 연결
cursor.execute("SELECT name FROM sqlite_master WHERE type='table';") #테이블보기
print(cursor.fetchall())   # 테이블 출력
cursor.execute("SELECT * FROM examtable;")
print(cursor.fetchall())   # 테이블 출력
# %%
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"나연\", 20990001, 95, 100, 95);")   #테이블내 레코드 삽입
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"정연\", 20990002, 90, 90, 85);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"모모\", 20990003, 95, 95, 75);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"사나\", 20990004, 85, 90, 90);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"지효\", 20990005, 100, 90, 85);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"미나\", 20990006, 90, 80, 90);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"다현\", 20990007, 75, 90, 100);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"채영\", 20990008, 95, 70, 90);")
cursor.execute("insert into examtable (name, studentid, kor, eng, mat) values (\"쯔위\", 20990009, 85, 90, 90);")

con.commit()
cursor.execute("SELECT * FROM examtable;")
print(cursor.fetchall())   # 테이블 출력
cursor.close()
con.close()

#%%
import sqlite3 as s
con=s.connect("mydata.db")
cursor = con.cursor()

cursor.execute("SELECT * FROM examtable")

one_rec=cursor.fetchall()  #해당 데이터를 전부 가져옴

for field in one_rec:  #해당 데이터를 반복문을 통해 하나씩 처리
    kor=field[2]  # SQL에서 인덱스는 1부터 시작
    eng=field[3]
    mat=field[4]
    print("이름:%s 학번:%s 국어:%3d 영어:%3d 수학:%3d 총점:%3d 평균:%3d"%(field[0],field[1],kor,eng,mat,kor+eng+mat,int((kor+eng+mat)/3)))

cursor.close()
con.close()
