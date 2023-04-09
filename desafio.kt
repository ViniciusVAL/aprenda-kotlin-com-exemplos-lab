enum class Level { BASIC, INTERMEDIARY, ADVANCED }

data class Users (val firstname: String, val lastname: String,  val age: Int, val email: String)

data class EducationalContent(val name: String, val duration: Int, val level: Level)

data class Formation(val name: String, val contents: List<EducationalContent>, val level: Level) {

    val register = mutableListOf<Users>()
         
    fun addUser(user: Users) {
        register.add(user)               
    }
    
    fun getAddUser(){
        for(user in register){
            println("|Nome: ${user.firstname+" "+user.lastname}| - |Idade: ${user.age}| - |Email: ${user.email}|")
        }
    }
    
    fun viewEducationalContent(){
        for(cont in contents){
            println("${cont.name} - ${cont.duration}min - (${cont.level})")
    }
}
    
}   
   

fun main() {
    
    //cadastrando usuarios
    val Vinicius = Users ("Vinicius", "Lima", 36, "vinicius.lima@gmail.com")
    val Daniela = Users ("Daniela", "Tomolos", 39, "daniela.tomolos@gmail.com")
    val Timoteo = Users ("Timoteo", "Oliveira", 30, "timoteo.oliveira@gmail.com")
    
    //cadastrando conteúdos educacionais
    val ModuloKotlin = EducationalContent ("Curso de Kotlin", 60, Level.BASIC)
    val ModuloJava = EducationalContent ("Curso de Java", 60, Level.BASIC)
    val ModuloKotlin2 = EducationalContent ("Curso de Kotlin Intermediario", 120, Level.INTERMEDIARY)
    val ModuloJava2 = EducationalContent ("Curso de Java Intermediario", 120, Level.INTERMEDIARY)
    
    //incluindo itens na lista de conteúdos educacionais
    val contentList = mutableListOf<EducationalContent>()
  		contentList.add(ModuloKotlin)
  		contentList.add(ModuloJava)
    	contentList.add(ModuloKotlin2)
  		contentList.add(ModuloJava2)
        
    //adicionando usuarios ao curso de formação    
    val androidTraining = Formation("Formação Android Developer", contentList, Level.INTERMEDIARY)
    	androidTraining.addUser(Vinicius)
   		androidTraining.addUser(Daniela)
    	androidTraining.addUser(Timoteo)
        
        
    	println("-----------------------------------------")
    	println("${androidTraining.name} - ${androidTraining.level}")
    	println("-----------------------------------------")

    	println("***Cursos***")
    	println(androidTraining.viewEducationalContent())
    	println("******************************************")

    	println("Usuarios cadastrados no curso")
    	println(androidTraining.getAddUser())
    
}