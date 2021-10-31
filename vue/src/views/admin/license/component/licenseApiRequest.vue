<script>
import axios from 'axios'

export default {
  data() {
    return {
    }
  },
  created() {
    this.fetchData('')
  },
  methods: {
    fetchData(query) {
      axios
        .get('http://localhost/licenses' + query)
        .then(res => {
          console.log(res.data)
          this.$emit('licenseInfo', res.data)
        })
        .catch(err => {
          alert('fail')
          console.log(err)
        })
    }
  }
}
</script>
