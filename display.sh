echo -n "Enter version number > "
read text
echo "You entered: $text"
FILE="db/$text.txt"
echo "*** File - $FILE contents ***"
cat $FILE
