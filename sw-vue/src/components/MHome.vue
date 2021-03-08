<template>
  <div>
    <nav-menu/>
    <router-view/>
  </div>
</template>

<script>
import NavMenu from './common/NavMenu'
export default {
  name: 'MHome',
  components: {
    NavMenu
  }
}
</script>

<style scoped>

</style>
