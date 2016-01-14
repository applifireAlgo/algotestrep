




echo $PATH
DB_PATH=/tmp/applifire/db/BRZBZVZK6L99JWHQEZ6HPW/AB02E856-465D-4C39-B500-98FFD83FF15C
MYSQL=/usr/bin
USER=testpro1
PASSWORD=testpro1
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'