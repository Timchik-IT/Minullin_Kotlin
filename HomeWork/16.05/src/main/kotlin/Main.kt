fun main(args: Array<String>) {
    First()
    Second()
    Third()
    Fourth()
}

fun Fourth(){
    println("Forth: ")
    val nums = arrayOf(1, 1, 2)
    println(removeDuplicates(nums))
}

fun Third(){
    println("Third: ")
    println(isPalindrome(123321))
}

fun Second(){
    println("Second: ")
    println(romanToInt("IV"))
}

fun First(){
    println("First: ")
    val nums1 : Array<Int> = arrayOf(2,7,11,15)
    val target : Int = 9
    val numbers : Array<Int> = twoSum(nums1, target)
    for(number in numbers){
        print("$number \t")
    }
    println()
}

fun removeDuplicates(nums: Array<Int>): Int {
    var current = nums[0]
    val expectedNums = arrayListOf<Int>(current)
    for (i in 0 until nums.size){
        if (current != nums[i]){
            current = nums[i]
            expectedNums.add(nums[i])
        }
    }
    return expectedNums.size
}

fun isPalindrome(x: Int): Boolean {
    var x = x
    if (x < 0){
        return true
    }
    val array = arrayListOf<Int>()
    while (x != 0) {
        array.add(x % 10)
        x /= 10
    }
    if (array.size % 2 == 1){
        for (i in 0..(array.size - 3) / 2){
            if (array[i] != array[array.size - 1 - i]){
                return false
            }
        }
    } else {
        for (i in 0..(array.size - 2 / 2)) {
            if (array[i] != array[array.size - 1 - i]){
                return false
            }
        }
    }
    return true
}

fun romanToInt(s: String): Int {
    val values = mapOf(
        'I' to 1, 'V' to 5, 'X' to 10,
        'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
    val s = s.reversed()
    var counter: Int = 0
    var step: Int = 0
    for(element in s) {
        val currentValue = values[element]!!
        if (step > currentValue) {
            counter -= currentValue
        } else {
            counter += currentValue
        }
        step = currentValue
    }
    return counter
}

fun twoSum(nums: Array<Int>, target: Int): Array<Int> {
    for (i in 0..nums.size){
        for (j in 0..nums.size){
            if (i != j && nums[i] + nums[j] == target){
                return arrayOf(i, j)
            }
        }
    }
    return emptyArray<Int>()
}