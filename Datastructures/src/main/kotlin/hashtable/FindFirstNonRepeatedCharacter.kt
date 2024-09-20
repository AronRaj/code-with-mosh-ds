package hashtable

fun getFirstNonRepeatedCharacter(message:String):Char{
    val data = message.trim()
    val charMap = HashMap<Char,Int>()
    for(char in data){
        if(!charMap.containsKey(char)){
            charMap.put(char,0)
        }else{
            charMap.get(char)?.let {  charMap.put(char, it+1)}
        }
    }
    for(char in data){
        charMap.get(char)?.let {
            if(it==0)
                return char
        }
    }
    return ' '
}

fun main(){
    println(getFirstNonRepeatedCharacter("a green apple is goat red"))
}