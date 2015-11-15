read -p "Commit description: " desc  
git add .
git commit -m "$desc"
git push origin master
read -p "Press [Enter] key to continue"