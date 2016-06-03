text="Commit"
sh ./init1.sh
while [ $text != "Exit" ]
do
echo -n "Commit/Display/Revert/Exit"

read text
if [ $text = "Commit" ]
then
 sh ./commit.sh
 echo "Commit Successfull"
fi
if [ $text = "Display" ]
then
 sh ./display.sh
 
fi
if [ $text = "Revert" ]
then
 sh ./revert.sh
 echo "Revert Successful"
fi
done


