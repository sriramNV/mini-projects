# program to fing the mean median and mode of a given set of numbers

from collections import Counter


n = list(map(int, input('Enter elements seperated by space').split()))

n.sort()


median = ((n[int(len(n)/2)] + n[int(len(n)/2) + 1]),(n[int(len(n)/2)]))[len(n) % 2 == 0]
mean = sum(n) / len(n)
count = Counter(n)
max = max(count.values())
mode = [key for key, value in count.items() if value == max]




print(f'Mean: {mean}, Median: {median} and Mode: {mode} ')
