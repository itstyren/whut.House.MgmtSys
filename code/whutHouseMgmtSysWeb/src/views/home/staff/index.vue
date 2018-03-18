<template>
  <div class="dashboard-admin">
    <el-row>
      <el-col :span="6" style="margin-left:50x">
          <el-row>
            <info-card></info-card>
          </el-row>
       <el-row>
           <notification></notification>
       </el-row>
      </el-col>
      <el-col :span="18" class="pannel-group">
      </el-col>
    </el-row>

  </div>
</template>

<script type="text/ecmascript-6">
  import infoCard from '../components/infoCard'
  import notification from './components/notification.vue'
  export default {
    data() {
      return {

      }

    },
    components: {
      infoCard,
      notification
    }
  }

</script>

<style scoped lang="scss">
.Notification{
    height: 100%
}

</style>
