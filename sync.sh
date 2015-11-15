COMMIT_TIMESTAMP=`date +'%Y-%m-%d %H:%M:%S %Z'`

git add .
git commit -m "Automated commit on ${COMMIT_TIMESTAMP}"
git push origin master
