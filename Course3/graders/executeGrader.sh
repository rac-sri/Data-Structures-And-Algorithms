#! /bin/bash
cd /grader

MOD1_PART1_ID="EmeoQ"
MOD1_PART2_ID="SnOzZ"
MOD2_ID="KzMMz"
MOD3_PART1_ID="PzTAu"
MOD3_PART2_ID="16MuO"

do_unzip () {
  7z e -ozipfile $1 > /dev/null
  if [ ! $? -eq 0 ]; then
    echo "{ \"fractionalScore\": 0.0, \"feedback\":\"Could not unzip input file. The grader does not support files such as .rar - try using .zip.\" }"
    exit 0;
  fi
}
  

while [ $# -gt 1 ]
  do
    key="$1"
    case $key in
      partId)
        PARTID="$2"
        shift
        ;;
      userId)
        USERID="$2"
        shift
        ;;
      filename)
        ORIGINAL_FILENAME="$2"
        shift
        ;;
    esac
  shift
done

if [ "$PARTID" == "$MOD1_PART1_ID" ] || [ "$PARTID" == "$MOD1_PART2_ID" ]; then
  if [ "$PARTID" == "$MOD1_PART1_ID" ]; then
    FILENAME="basicgraph.DegreeGrader"
  else
    FILENAME="basicgraph.GraphGrader"
  fi
  GRADER_DIRECTORY="mod1"
  do_unzip /shared/submission/mod1.zip
  cd zipfile
  if [ ! -f "GraphAdjList.java" ]; then
    rm -rf __MACOSX > /dev/null
    cd *
  fi
  cp * /grader/"$GRADER_DIRECTORY"/basicgraph/
  cd /grader/"$GRADER_DIRECTORY"
  javac -encoding ISO-8859-1 basicgraph/*.java 2>errorfile
elif [ "$PARTID" == "$MOD2_ID" ]; then
  FILENAME="roadgraph.SearchGrader"
  GRADER_DIRECTORY="mod2"
  do_unzip /shared/submission/mod2.zip
  cd zipfile
  if [ ! -f "MapGraph.java" ]; then
    rm -rf __MACOSX > /dev/null
    cd *
  fi
  cp * /grader/"$GRADER_DIRECTORY"/roadgraph/ 
  cd /grader/"$GRADER_DIRECTORY"
  javac -encoding ISO-8859-1 roadgraph/*.java 2>errorfile
elif [ "$PARTID" == "$MOD3_PART1_ID" ] || [ "$PARTID" == "$MOD3_PART2_ID" ]; then
  if [ "$PARTID" == "$MOD3_PART1_ID" ]; then
    FILENAME="roadgraph.DijkstraGrader"
  else
    FILENAME="roadgraph.AStarGrader"
  fi
  GRADER_DIRECTORY="mod3"
  do_unzip /shared/submission/mod3.zip
  cd zipfile
  if [ ! -f "MapGraph.java" ]; then
    rm -rf __MACOSX > /dev/null
    cd *
  fi
  cp * /grader/"$GRADER_DIRECTORY"/roadgraph/
  cd /grader/"$GRADER_DIRECTORY"
  javac -encoding ISO-8859-1 roadgraph/*.java 2>errorfile

else
  echo "{ \"fractionalScore\": 0.0, \"feedback\":\"No partID matched: "$PARTID"\" }"
  exit 1
fi

if [ ! $? -eq 0 ]; then
  cp errorfile /grader
  python /grader/compile_error.py
  exit 0
fi

java "$FILENAME" > extra.out 2> err.out
if [ -s output.out ]; then
  cat output.out
else
  cp extra.out err.out /grader
  python /grader/no_output.py
  exit 0
fi
