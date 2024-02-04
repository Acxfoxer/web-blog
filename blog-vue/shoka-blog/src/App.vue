<template>
  <Provider>
    <div class="app-wrapper">
      <Header></Header>
      <main class="main-wrapper">
        <router-view v-slot="{ Component, route }">
          <keep-alive>
            <component :is="Component" :key="route.path" />
          </keep-alive>
        </router-view>
      </main>
      <Footer></Footer>
      <Tool></Tool>
      <Search></Search>
      <Login></Login>
      <Register></Register>
      <Forget></Forget>
      <Email></Email>
      <Drawer></Drawer>
      <MusicPlayer></MusicPlayer>
      <ChatRoom></ChatRoom>
    </div>
  </Provider>
</template>

<script setup lang="ts">
import { getBlogInfo, recordVisitorInfo } from "@/api/blogInfo";
import useStore from '@/store';
const { blog } = useStore();
onMounted(() => {
  getBlogInfo().then(({ data }) => {
    blog.setBlogInfo(data.data);
  });
  recordVisitorInfo();
})
</script>

<style scoped>
.app-wrapper {
  position: relative;
  min-height: 100vh;

}

.main-wrapper {
  display: flex;
  flex-direction: column;
  width: 100%;
  padding: 0 0 8rem;
}
</style>