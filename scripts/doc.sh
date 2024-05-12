packages=$(echo $(ls app) | sed 's/ /:/g')
javadoc -d "${1}" -sourcepath "${2}" -subpackages "${packages}"
