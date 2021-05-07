# Java example
# class  elevator
# {
#    int limit-up-floor=10; //최상위 층
#    int down-floor=0; //최하위층
#    int floor; //현재층
#    char help[100]; 
#    void up()  //엘리베이터가 올라감
#    {
#       if (floor == limit-up-floor)
#          help=“ last-floor”;
#        else
#           floor++; //최상층이 아닐 때 한 층씩 올라감
#    }     
#    void down() //엘리베이터가 내려감
#    {
#        if (floor == limit-down-floor)
#          help=“ last-floor”;
#        else
#           floor++; //최하층이 아닐 때 한 층씩 올라감
#    }
# }

#%%
# main part
myclass = elevator(1,15,0,"") #(현재1층, 최저0층, 최고15층, 메시지)
                              #값으로 클래스생성

for i in range(20):  #20번 up()를 실행
    myclass.up()
for i in range(20):  #20번 down()을 실
    myclass.down()

class elevator:
    def __init__(self,floor,limit_up_floor,limit_down_floor,msg):
        self.floor=floor   #클래스 내 변수에 self 붙임
        self.limit_up_floor=limit_up_floor
        self.limit_down_floor=limit_down_floor
        self.msg=msg        
    def up(self):
        if self.floor == self.limit_up_floor:
            self.msg="최상층 입니다"
        else:
            self.floor+=1
            self.msg=str(self.floor)+"층입니다"
        print(self.msg)
    def down(self):
        if self.floor == self.limit_down_floor:
            self.msg="최하층 입니다"
        else:
            self.floor-=1
            self.msg=str(self.floor)+"층입니다"
        print(self.msg)
