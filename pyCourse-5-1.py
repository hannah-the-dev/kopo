#%%
import math
# won = int(input("Please input won amount"))
won = 1000000
rate = 1010.12
feeRate = 0.002
dolwFee = (won / (rate + feeRate))
# dollar = (dolwFee / (1+feeRate)) - (dolwFee / (1+feeRate)) % 1
dollar = math.floor(dolwFee / (1+feeRate))
fee = math.ceil(dollar * rate * feeRate)
change = math.floor(won - dollar * rate - fee)

print("***************************************************")
print("총금액:", won,"원"," 달러환율:", rate,"$")
print("지급달러:", dollar,"$")
print("거스름돈:", change,"원", " 은행수수료:", fee,"원")
print("***************************************************")

# %%
