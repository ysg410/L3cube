file="count.txt"
while IFS= read line
do
   temp1=$line
done <"$file"
temp1=$(($temp1+1));
i=0
while [ $i -lt $temp1 ]
do
  rm -f db/$i.txt;
  i=$(($i+1));
done

echo 0 > "count.txt"
