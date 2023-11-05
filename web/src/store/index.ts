import { createStore } from 'vuex';

const USER = "USER";

const store = createStore({
  state: {
    user: JSON.parse(sessionStorage.getItem(USER) || '{}')
  },
  mutations: {
    setUser (state, user) {
      console.log("store user：", user);
      state.user = user;
      sessionStorage.setItem(USER, JSON.stringify(user));
    }
  },
  actions: {
    // 可以在这里定义你的 actions
  },
  modules: {
    // 如果需要，可以在这里定义模块
  }
});

export default store;
