@ECHO OFF
CLS
java -cp bin;res;lib\*; -Djava.library.path=nat Game
@ECHO ON