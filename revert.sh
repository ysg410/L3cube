echo -n "Enter version number > "
read text
cp db/$text.txt test.txt

file="count.txt"
while IFS= read line
do
    temp1=$line
	
done <"$file"
echo $text > "count.txt"
i=temp1;

while [ $i > $text ]
do
  rm -f db/$i.txt;
  i=$(($i-1));
done


