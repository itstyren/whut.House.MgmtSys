import Cookies from 'js-cookie'

const app = {
  state: {
    language: Cookies.get('language') || 'en',
    seachVisible: false
  },
  mutations: {
    SET_LANGUAGE: (state, language) => {
      state.language = language
      Cookies.set('language', language)
    },
    SET_DIALOG_VISIBLE:(state,bool)=>{
      state.seachVisible=bool
    }
  },
  actions: {
    setLanguage({commit}, language) {
      commit('SET_LANGUAGE', language)
    },
    setSeachHouse({commit},bool){
      commit('SET_DIALOG_VISIBLE',bool)
    }
  }
}

export default app
