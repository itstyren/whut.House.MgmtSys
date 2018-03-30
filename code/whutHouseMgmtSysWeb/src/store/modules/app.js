import Cookies from 'js-cookie'

const app = {
  state: {
    language: Cookies.get('language') || 'en',
    seachVisible: false,
    staffShow:false,
    todayData:{}
  },
  mutations: {
    SET_LANGUAGE: (state, language) => {
      state.language = language
      Cookies.set('language', language)
    },
    SET_DIALOG_VISIBLE:(state,bool)=>{
      state.seachVisible=bool
    },
    SET_STAFF_SHOW:(state,bool)=>{
      state.staffShow=bool
    },
    SET_TODAY_DATA:(state,object)=>{
      state.todayData=object
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
