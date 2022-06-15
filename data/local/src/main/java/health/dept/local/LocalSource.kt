package health.dept.local

interface LocalSource {
    fun storeToken(token: String)
    fun getToken(): String?
}