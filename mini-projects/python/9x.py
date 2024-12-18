# Timepass, for multiplying any number with 9, there exist an interesting solution: 9 x n = (n-1)((9-n) + 1) where n-1 is first ddigit and ((9-n) + 1) is
# second digit

n = int(input("enter the number to be multiplied by 9: "))

first_num = n - 1
second_num = 9 - n + 1

result = str(first_num) + str(second_num)

print(result)