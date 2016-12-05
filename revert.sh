echo -n "Enter version number > "
read text
text1=text
temp1=0
cp db/$text.txt test.txt

file="count.txt"
while IFS= read line
do
    temp1=$line
    i=$line	
done <"$file"
echo $text > "count.txt"

while [ $i -gt $text ]
do
   rm -f db/$i.txt
  
  i=$((i-1))
done


