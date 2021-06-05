package com.pailsom.kotlin

fun main(arg:Array<String>) {
    var solution = MaxAreaOfIsland()
    var grid = arrayOf(intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),
        intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),
        intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),
        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
        intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0))
    var output:Int =  solution.maxAreaOfIsland(grid)
    println(output)
}
class MaxAreaOfIsland {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea:Int = 0
        var row = grid.size
        var col = grid[0].size
        for (r in 0 until row){
            for (c in 0 until col){
                if (grid[r][c]==1){
                    var islandIndexs = ArrayList<String>()
                    markCurrentIsland(grid,r,c,row,col,islandIndexs)
                    if(islandIndexs.size>maxArea) {
                        maxArea = islandIndexs.size
                    }
                }
            }
        }
        return maxArea
    }

    private fun markCurrentIsland(grid: Array<IntArray>, r: Int, c: Int, row: Int, col: Int, islandIndexs: ArrayList<String>) {
        if(r<0 || r>=row || c<0 || c>=col || grid[r][c]!=1)
            return
        grid[r][c]=2
        islandIndexs.add("$r $c")
        markCurrentIsland(grid,r+1,c,row,col,islandIndexs)
        markCurrentIsland(grid,r-1,c,row,col,islandIndexs)
        markCurrentIsland(grid,r,c+1,row,col,islandIndexs)
        markCurrentIsland(grid,r,c-1,row,col,islandIndexs)
    }

}