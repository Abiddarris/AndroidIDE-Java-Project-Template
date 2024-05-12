if [ ! -d "${1}" ]; then
    mkdir $1 > /dev/null
    if [ $? -ne 0 ]; then
        exit 1
    fi   
fi

dest=$(realpath "$1""/""$2")
cd "${3}"
jar -cf "${dest}" *