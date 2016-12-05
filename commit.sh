file="count.txt"
while IFS= read line
do
    cp test.txt db/$line.txt    # display $line or do somthing with $line
	temp1=$line
	temp1=$(($temp1+1));

done <"$file"


echo $temp1 > "count.txt"
