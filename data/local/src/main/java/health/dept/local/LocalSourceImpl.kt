package health.dept.local

import javax.inject.Inject

class LocalSourceImpl @Inject constructor(
    private val manager: PreferenceManager
) : LocalSource {

    override fun storeToken(token: String) {
        manager.store(PreferenceManager.Key.TOKEN, token)
    }

    override fun getToken(): String? {
        return manager.getString(PreferenceManager.Key.TOKEN)
    }
}